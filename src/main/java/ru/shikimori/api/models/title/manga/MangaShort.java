package ru.shikimori.api.models.title.manga;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import ru.shikimori.api.constants.enums.MangaKind;
import ru.shikimori.api.models.Credential;
import ru.shikimori.api.models.title.TitleShort;

public class MangaShort extends TitleShort {

    @SerializedName("volumes")
    @Expose
    private int volumes;

    @SerializedName("chapters")
    @Expose
    private int chapters;

    //private MangaShort(){}

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

    public Manga getFullInfo(){
        return Manga.getById(this.id);
    }

    public Manga getFullInfo(Credential credential){
        return Manga.getById(this.id, credential);
    }


    public static MangaShort toConvert(Manga manga){
        if (manga == null) return null;

        MangaShort mangaShort = new MangaShort();

        mangaShort.id = manga.getId();
        mangaShort.name = manga.getName();
        mangaShort.russian = manga.getRussian();
        mangaShort.image = manga.getImage();
        mangaShort.url = manga.getUrl();
        mangaShort.kind = manga.getKind().name();
        mangaShort.releaseStatus = manga.getReleaseStatus().name();
        mangaShort.airedDate = manga.getAiredDate().toString();
        mangaShort.releasedDate = manga.getReleasedDate().toString();

        mangaShort.volumes = manga.getVolumes();
        mangaShort.chapters = manga.getChapters();

        return mangaShort;
    }

    public static MangaShort[] toConvert(Manga[] mangas){
        if (mangas == null || mangas.length == 0) return null;

        MangaShort[] mangaShorts = new MangaShort[mangas.length];
        for (int i = 0; i < mangas.length; i++){
            mangaShorts[i] = MangaShort.toConvert(mangas[i]);
        }

        return mangaShorts;
    }

}
