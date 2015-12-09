package rivero.daniel.paymet.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.nio.charset.Charset;
import java.util.ArrayList;

import rivero.daniel.paymet.Model.Post;
import rivero.daniel.paymet.R;

/**
 * Created by daniel on 8/12/15.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.PostsViewHolder> implements View.OnClickListener {

    private View.OnClickListener listener;
    private ArrayList<Post> posts;

    public RecyclerAdapter(ArrayList<Post> posts) {
        this.posts = posts;
    }

    public static class PostsViewHolder extends RecyclerView.ViewHolder{

        private ImageView img;
        private TextView title;
        private TextView subtitle;
        private Context context;

        public PostsViewHolder(View itemView) {
            super(itemView);

            context = itemView.getContext();
            img = (ImageView)itemView.findViewById(R.id.imgThumbnail);
            title = (TextView)itemView.findViewById(R.id.titlePost);
            subtitle = (TextView)itemView.findViewById(R.id.subtitlePost);
        }

        public void bindPost(Post p){

            Glide.with(context)
                    .load(p.getMainImage())
                    .centerCrop()
                    .crossFade()
                    .into(img);
            title.setText(Html.fromHtml(p.getTitle()));
            subtitle.setText(Html.fromHtml(p.getSubtitle()));
        }
    }

    @Override
    public PostsViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.items_recycler, viewGroup, false);

        itemView.setOnClickListener(this);

        PostsViewHolder pvh = new PostsViewHolder(itemView);

        return pvh;
    }

    @Override
    public void onBindViewHolder(PostsViewHolder viewHolder, int position) {
        Post p = posts.get(position);

        viewHolder.bindPost(p);
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }


    @Override
    public void onClick(View v) {
        if(listener != null)
            listener.onClick(v);
    }

}
