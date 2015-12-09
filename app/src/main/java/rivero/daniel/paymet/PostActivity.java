package rivero.daniel.paymet;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class PostActivity extends AppCompatActivity {

    ImageView image;
    TextView title;
    TextView content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        configureToolbar();

        image = (ImageView)findViewById(R.id.mainImage);
        title = (TextView)findViewById(R.id.titlePost);
        content = (TextView)findViewById(R.id.textPost);

        Intent i = getIntent();
        String img = i.getStringExtra("img");
        String tlt = i.getStringExtra("title");
        String cnt = i.getStringExtra("content");

        Glide.with(this)
                .load(img)
                .centerCrop()
                .placeholder(R.drawable.ted_logo)
                .crossFade()
                .into(image);

        title.setText(Html.fromHtml(tlt));
        content.setText(Html.fromHtml(cnt));

    }

    public void configureToolbar(){
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle("");
            ab.setHomeAsUpIndicator(R.drawable.arrow_left);
            ab.setDisplayHomeAsUpEnabled(true);
        }
    }

}
