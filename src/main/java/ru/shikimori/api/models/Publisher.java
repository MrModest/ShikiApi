package ru.shikimori.api.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Publisher {

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("name")
    @Expose
    private String name;

    private Publisher(){}

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
