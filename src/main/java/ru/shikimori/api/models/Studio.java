package ru.shikimori.api.models;

import ru.shikimori.api.models.json._Studio;

public class Studio {

    private int id;
    private String name;
    private String filteredName;
    private boolean real;
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

    public static Studio convertFromJsonModel(_Studio _studio){
        if (_studio == null) { return null; }

        Studio studio = new Studio();
        studio.id = _studio.id;
        studio.name = _studio.name;
        studio.filteredName = _studio.filtered_name;
        studio.real = _studio.real;
        studio.image = _studio.image;

        return studio;
    }

    public static Studio[] convertFromJsonModel(_Studio[] _studios){
        if (_studios == null || _studios.length == 0) { return null; }

        Studio[] studios = new Studio[_studios.length];
        for (int i = 0; i < _studios.length; i++){
            studios[i] = Studio.convertFromJsonModel(_studios[i]);
        }

        return studios;
    }
}
