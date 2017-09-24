package ru.shikimori.api.models;

import ru.shikimori.api.models.json._Genre;

public class Genre {

    private int id;
    private String name;
    private String russian;
    private String kind;

    private Genre(){}

    /*public Genre(_Genre _genre){
        if (_genre == null) { return; }
        this.id = _genre.id;
        this.name = _genre.name;
        this.russian = _genre.russian;
        this.kind = _genre.kind;
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

    public String getKind() {
        return kind;
    }

    public static Genre convertFromJsonModel(_Genre _genre){
        if (_genre == null) { return null; }

        Genre genre = new Genre();
        genre.id = _genre.id;
        genre.name = _genre.name;
        genre.russian = _genre.russian;
        genre.kind = _genre.kind;

        return genre;
    }

    public static Genre[] convertFromJsonModel(_Genre[] _genres){
        if (_genres == null || _genres.length == 0) { return null; }

        Genre[] genres = new Genre[_genres.length];
        for (int i = 0; i < _genres.length; i++){
            genres[i] = Genre.convertFromJsonModel(_genres[i]);
        }

        return genres;
    }
}
