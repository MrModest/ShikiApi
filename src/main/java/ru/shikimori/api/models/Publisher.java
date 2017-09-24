package ru.shikimori.api.models;

import ru.shikimori.api.models.json._Publisher;

public class Publisher {

    private int id;
    private String name;

    private Publisher(){}

    public static Publisher convertFromJsonModel(_Publisher _publisher){
        if (_publisher == null) { return null; }

        Publisher publisher = new Publisher();
        publisher.id = _publisher.id;
        publisher.name = _publisher.name;

        return publisher;
    }

    public static Publisher[] convertFromJsonModel(_Publisher[] _publishers){
        if (_publishers == null || _publishers.length == 0) { return null; }

        Publisher[] publishers = new Publisher[_publishers.length];
        for (int i = 0; i < _publishers.length; i++){
            publishers[i] = Publisher.convertFromJsonModel(_publishers[i]);
        }

        return publishers;
    }

}
