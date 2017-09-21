package ru.shikimori.api.models;

import ru.shikimori.api.models.json._Genre;

public class Genre {

    private int id;
    private String name;
    private String russian;
    private String kind;

    public Genre(){}

    public Genre(_Genre _genre){
        if (_genre == null) { return; }
        this.id = _genre.id;
        this.name = _genre.name;
        this.russian = _genre.russian;
        this.kind = _genre.kind;
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

    public String getKind() {
        return kind;
    }
}
