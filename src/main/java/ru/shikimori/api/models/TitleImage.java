package ru.shikimori.api.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TitleImage {

    @SerializedName("original")
    @Expose
    private String original;

    @SerializedName("preview")
    @Expose
    private String preview;

    @SerializedName("x96")
    @Expose
    private String x96;

    @SerializedName("x48")
    @Expose
    private String x48;

    private TitleImage(){}

    public String getOriginal() {
        return original;
    }

    public String getPreview() {
        return preview;
    }

    public String getX96() {
        return x96;
    }

    public String getX48() {
        return x48;
    }

}
