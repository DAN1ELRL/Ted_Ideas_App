package rivero.daniel.paymet.Retrofit;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by daniel on 8/12/15.
 */
public interface WordpressAPI {

    @GET("/posts")
    void getPosts(Callback<RespuestaAPI> cb);

}
