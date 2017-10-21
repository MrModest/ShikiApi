package ru.shikimori.api.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import ru.shikimori.api.models.filter.Filterable;

public class Genre implements Filterable {

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("russian")
    @Expose
    private String russian;

    @SerializedName("kind")
    @Expose
    private String kind;

    private Genre(){}

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRussian() {
        return russian;
    }

    public String getKind() {
        return kind;
    }

    @Override
    public String getFilterData() {
        return Integer.toString(this.id);
    }


    public static Genre[] getEmpty(int... ids){
        Genre[] genres = new Genre[ids.length];
        for(int i = 0; i < ids.length; i++){
            Genre genre = new Genre();
            genre.id = ids[i];
            genres[i] = genre;
        }
        return genres;
    }
}
