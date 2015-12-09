package rivero.daniel.paymet.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by daniel on 8/12/15.
 */
public class ListaPosts {
    @SerializedName("posts")
    ArrayList<Post> posts;

    public ListaPosts(ArrayList<Post> posts) {
        this.posts = posts;
    }

    public ArrayList<Post> getPosts() {
        return posts;
    }

    public void setPosts(ArrayList<Post> posts) {
        this.posts = posts;
    }
}
