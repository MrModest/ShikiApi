package ru.shikimori.api.models.json;

import ru.shikimori.api.models.UserShort;

public class _Message {

    public int id;
    public String kind;
    public boolean read;
    public String body;
    public String html_body;
    public String created_at;
    //public _MessageLink linked;
    public UserShort from;
    public UserShort to;

}
