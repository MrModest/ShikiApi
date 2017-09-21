package ru.shikimori.api.models;

import ru.shikimori.api.models.json._TitleImage;
import ru.shikimori.api.models.json._TitleShortInfo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TitleShort {

    private int id;
    private String name;
    private String russian;
    private _TitleImage image;
    private String url;
    private String kind;
    private String status;
    private LocalDateTime airedDate;
    private LocalDateTime releasedDate;

    public TitleShort(){}

    public TitleShort(_TitleShortInfo _titleShort){
        if (_titleShort == null) { return; }
        this.id = _titleShort.id;
        this.name = _titleShort.name;
        this.russian = _titleShort.russian;
        this.image = _titleShort.image;
        this.url = _titleShort.url;
        this.kind = _titleShort.kind;
        this.status = _titleShort.status;
        this.airedDate = LocalDateTime.parse(_titleShort.aired_on, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        this.releasedDate = LocalDateTime.parse(_titleShort.released_on, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

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

    public LocalDateTime getAiredDate() {
        return airedDate;
    }

    public LocalDateTime getReleasedDate() {
        return releasedDate;
    }
}