package ru.shikimori.api.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TitleScreenshot {

    @SerializedName("original")
    @Expose
    private String original;

    @SerializedName("preview")
    @Expose
    private String preview;

    private TitleScreenshot(){}

    public String getOriginal() {
        return original;
    }

    public String getPreview() {
        return preview;
    }

}
