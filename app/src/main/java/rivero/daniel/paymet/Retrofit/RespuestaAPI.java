package rivero.daniel.paymet.Retrofit;

import java.util.ArrayList;

import rivero.daniel.paymet.Model.Post;

/**
 * Created by daniel on 8/12/15.
 */
public class RespuestaAPI {
    private int numReg;
    private ArrayList<Post> posts;

    public RespuestaAPI(){
        numReg = -1;
        posts = null;
    }

    public int getNumReg() {
        return numReg;
    }

    public void setNumReg(int numReg) {
        this.numReg = numReg;
    }

    public ArrayList<Post> getPosts() {
        return posts;
    }

    public void setPosts(ArrayList<Post> posts) {
        this.posts = posts;
    }

    public Post getPost(int index){return posts.get(index);}
}
