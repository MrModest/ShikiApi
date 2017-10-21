package ru.shikimori.api.models.title.manga;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import ru.shikimori.api.constants.enums.MangaKind;
import ru.shikimori.api.models.Credential;
import ru.shikimori.api.models.Publisher;
import ru.shikimori.api.models.filter.MangaFilter;
import ru.shikimori.api.models.title.Title;
import ru.shikimori.api.requests.QueryShell;

public class Manga extends Title {

    @SerializedName("volumes")
    @Expose
    private int volumes;

    @SerializedName("chapters")
    @Expose
    private int chapters;

    @SerializedName("publishers")
    @Expose
    private Publisher[] publishers;

    //private Manga(){}

    @Override
    public MangaKind getKind(){
        return MangaKind.fromString(this.kind);
    }

    public int getVolumes() {
        return volumes;
    }

    public int getChapters() {
        return chapters;
    }

    public Publisher[] getPublishers() {
        return publishers;
    }

    public static Manga getById(int titleId){
        if (titleId < 1) { return null; }

        return QueryShell.get("mangas/" + titleId, Manga.class);
    }

    public static Manga getById(int titleId, Credential credential){
        if (titleId < 1) { return null; }

        return QueryShell.get("mangas/" + titleId, Manga.class, credential);
    }

    public static MangaFilter newSearch(){
        return new MangaFilter();
    }

    public static MangaFilter newSearch(String searchText){
        return new MangaFilter(searchText);
    }

}
