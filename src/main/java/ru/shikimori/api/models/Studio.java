package ru.shikimori.api.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Studio {

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("filtered_name")
    @Expose
    private String filteredName;

    @SerializedName("real")
    @Expose
    private boolean real;

    @SerializedName("image")
    @Expose
    private String image;

    private Studio(){}

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFilteredName() {
        return filteredName;
    }

    public boolean isReal() {
        return real;
    }

    public String getImage() {
        return image;
    }

}
