package ru.shikimori.api.models.json;

public class _Message {

    public int id;
    public String kind;
    public boolean read;
    public String body;
    public String html_body;
    public String created_at;
    //public _MessageLink linked;
    public _UserShortInfo from;
    public _UserShortInfo to;

}
