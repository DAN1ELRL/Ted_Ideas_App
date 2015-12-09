package rivero.daniel.paymet;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import rivero.daniel.paymet.Adapters.RecyclerAdapter;
import rivero.daniel.paymet.Model.Post;
import rivero.daniel.paymet.Retrofit.RespuestaAPI;
import rivero.daniel.paymet.Retrofit.WordPressService;
import rivero.daniel.paymet.Retrofit.WordpressAPI;

public class MainActivity extends AppCompatActivity {

    private static WordpressAPI servicio;
    private RecyclerView recView;
    private SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        servicio = WordPressService.getInstance();

        //servicio.getPosts(new obtenerRespuesta());

        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                servicio.getPosts(new obtenerRespuesta());
            }
        });

        mSwipeRefreshLayout.post(new Runnable() {
                                     @Override
                                     public void run() {
                                         // Muestro en la UI el circular progress bar
                                         mSwipeRefreshLayout.setRefreshing(true);
                                         servicio.getPosts(new obtenerRespuesta());
                                     }
                                 }
        );

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class obtenerRespuesta implements Callback<RespuestaAPI>{

        @Override
        public void success(RespuestaAPI respuestaAPI, Response response) {
            cargarDatos(respuestaAPI);
            mSwipeRefreshLayout.setRefreshing(false);
        }

        @Override
        public void failure(RetrofitError error) {
            Log.e("ERROR", error.toString());
            Toast.makeText(getApplicationContext(), "Error en el acceso a la API", Toast.LENGTH_LONG).show();

        }
    }

    private void cargarDatos(final RespuestaAPI respuestaAPI) {
        if(respuestaAPI.getNumReg()>0){
            recView = (RecyclerView) findViewById(R.id.recView);
            recView.setHasFixedSize(true);

            final RecyclerAdapter adaptador = new RecyclerAdapter(respuestaAPI.getPosts());

            adaptador.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(v.getContext(), PostActivity.class);
                    Post post = respuestaAPI.getPost(recView.getChildPosition(v));

                    i.putExtra("img", post.getMainImage());
                    i.putExtra("title", post.getTitle());
                    i.putExtra("content", post.getContent());
                    //i.putParcelableArrayListExtra("data", respuestaAPI.getPost(recView.getChildPosition(v)));
                    startActivity(i);
                }
            });

            recView.setAdapter(adaptador);

            recView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

            recView.setItemAnimator(new DefaultItemAnimator());
        }
    }
}
