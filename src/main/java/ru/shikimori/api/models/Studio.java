package ru.shikimori.api.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import ru.shikimori.api.models.filter.Filterable;

public class Studio implements Filterable {

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

    @Override
    public String getFilterData() {
        return Integer.toString(this.id);
    }


    public static Studio[] getEmpty(int... ids){
        Studio[] studios = new Studio[ids.length];
        for(int i = 0; i < ids.length; i++){
            studios[i].id = ids[i];
        }
        return studios;
    }
}
