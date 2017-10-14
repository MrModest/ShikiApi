package ru.shikimori.api.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserImage {

    @SerializedName("x160")
    @Expose
    private String x160;

    @SerializedName("x148")
    @Expose
    private String x148;

    @SerializedName("x80")
    @Expose
    private String x80;

    @SerializedName("x64")
    @Expose
    private String x64;

    @SerializedName("x48")
    @Expose
    private String x48;

    @SerializedName("x32")
    @Expose
    private String x32;

    @SerializedName("x16")
    @Expose
    private String x16;

    private UserImage(){}

    public String getX160() {
        return x160;
    }

    public String getX148() {
        return x148;
    }

    public String getX80() {
        return x80;
    }

    public String getX64() {
        return x64;
    }

    public String getX48() {
        return x48;
    }

    public String getX32() {
        return x32;
    }

    public String getX16() {
        return x16;
    }
}
