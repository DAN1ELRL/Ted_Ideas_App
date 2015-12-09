package rivero.daniel.paymet.Model;

import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by daniel on 8/12/15.
 */
public class Post {

    @SerializedName("ID")
    private String id;

    @SerializedName("title")
    private String title;

    @SerializedName("date")
    private String date;

    @SerializedName("URL")
    private String url;

    @SerializedName("content")
    private String content;

    @SerializedName("excerpt")
    private String subtitle;

    @SerializedName("featured_image")
    private String mainImage;

    public Post(String id, String title, String date, String url, String content, String subtitle, String mainImage) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.url = url;
        this.content = content;
        this.subtitle = subtitle;
        this.mainImage = mainImage;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage(String mainImage) {
        this.mainImage = mainImage;
    }



}
