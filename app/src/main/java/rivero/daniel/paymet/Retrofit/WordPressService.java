package rivero.daniel.paymet.Retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * Created by daniel on 8/12/15.
 */
public class WordPressService {

    private static WordpressAPI ourInstance = null;

    private String URL = "https://public-api.wordpress.com/rest/v1/sites/ideas.ted.com";

    public static WordpressAPI getInstance(){
        if(ourInstance == null){
            new WordPressService();
        }
        return ourInstance;
    }

    private WordPressService(){
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(RespuestaAPI.class, new PostDeserializer())
                .create();

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setConverter(new GsonConverter(gson))
                .setEndpoint(URL)
                .build();
        ourInstance = restAdapter.create(WordpressAPI.class);

    }
}
