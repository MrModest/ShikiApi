package ru.shikimori.api.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import ru.shikimori.api.models.filter.Filterable;

public class Publisher implements Filterable {

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

    @Override
    public String getFilterData() {
        return Integer.toString(this.id);
    }


    public static Publisher[] getEmpty(int... ids){
        Publisher[] publishers = new Publisher[ids.length];
        for(int i = 0; i < ids.length; i++){
            publishers[i].id = ids[i];
        }
        return publishers;
    }
}
