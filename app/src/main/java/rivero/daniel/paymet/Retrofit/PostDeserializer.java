package rivero.daniel.paymet.Retrofit;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import rivero.daniel.paymet.Model.Post;

public class PostDeserializer implements JsonDeserializer<RespuestaAPI>{
    @Override
    public RespuestaAPI deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        RespuestaAPI respuesta = new RespuestaAPI();
        JsonObject datos = json.getAsJsonObject();

        respuesta.setNumReg(datos.get("found").getAsInt());

        if(respuesta.getNumReg()>0){
            Type collectionType = new TypeToken<ArrayList<Post>>(){}.getType();
            ArrayList<Post> posts = (new Gson()).fromJson(datos.getAsJsonArray("posts"),collectionType);
            respuesta.setPosts(posts);
        }
        return respuesta;
    }
}
