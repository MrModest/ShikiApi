package ru.shikimori.api.models;

import ru.shikimori.api.models.json._MangaShortInfo;
import ru.shikimori.api.utils.DateUtils;

public class MangaShort extends TitleShort {

    private int volumes;
    private int chapters;

    private MangaShort(){}

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

    public static MangaShort convertFromJsonModel(_MangaShortInfo _titleShort){
        if (_titleShort == null) { return null; }

        MangaShort titleShort = new MangaShort();
        titleShort.id = _titleShort.id;
        titleShort.name = _titleShort.name;
        titleShort.russian = _titleShort.russian;
        titleShort.image = _titleShort.image;
        titleShort.url = _titleShort.url;
        titleShort.kind = _titleShort.kind;
        titleShort.status = _titleShort.status;
        titleShort.airedDate = DateUtils.formatDateFromString(_titleShort.aired_on);
        titleShort.releasedDate = DateUtils.formatDateFromString(_titleShort.released_on);

        titleShort.volumes = _titleShort.volumes;
        titleShort.chapters = _titleShort.chapters;

        return titleShort;
    }

    public static MangaShort[] convertFromJsonModel(_MangaShortInfo[] _titleShorts){
        if (_titleShorts == null || _titleShorts.length == 0) { return null; }

        MangaShort[] titleShort = new MangaShort[_titleShorts.length];
        for (int i = 0; i < _titleShorts.length; i++){
            titleShort[i] = MangaShort.convertFromJsonModel(_titleShorts[i]);
        }

        return titleShort;
    }
}
