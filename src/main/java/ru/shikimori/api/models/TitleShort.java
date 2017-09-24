package ru.shikimori.api.models;

import ru.shikimori.api.models.json._TitleImage;
import ru.shikimori.api.models.json._TitleShortInfo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class TitleShort {

    protected int id;
    protected String name;
    protected String russian;
    protected _TitleImage image;
    protected String url;
    protected String kind;
    protected String status;
    protected LocalDate airedDate;
    protected LocalDate releasedDate;

    protected TitleShort(){}

    /*public TitleShort(_TitleShortInfo _titleShort){
        if (_titleShort == null) { return; }
        this.id = _titleShort.id;
        this.name = _titleShort.name;
        this.russian = _titleShort.russian;
        this.image = _titleShort.image;
        this.url = _titleShort.url;
        this.kind = _titleShort.kind;
        this.status = _titleShort.status;
        this.airedDate = LocalDate.parse(_titleShort.aired_on, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        this.releasedDate = LocalDate.parse(_titleShort.released_on, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }*/

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRussian() {
        return russian;
    }

    public _TitleImage getImage() {
        return image;
    }

    public String getUrl() {
        return url;
    }

    public String getKind() {
        return kind;
    }

    public String getStatus() {
        return status;
    }

    public LocalDate getAiredDate() {
        return airedDate;
    }

    public LocalDate getReleasedDate() {
        return releasedDate;
    }

}