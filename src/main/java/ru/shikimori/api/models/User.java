package ru.shikimori.api.models;

import ru.shikimori.api.models.exceptions.ErrorStack;
import ru.shikimori.api.models.json._Statuses;
import ru.shikimori.api.models.json._UserFullInfo;
import ru.shikimori.api.models.json._UserShortInfo;
import ru.shikimori.api.requests.QueryShell;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class User extends UserShort {

    private String name;
    private String sex;
    private String onlineString;
    private _Statuses listStats;
    private boolean banned;
    private boolean friend;
    private boolean ignored;

    private User(){}

    /*public User(_UserFullInfo _user) {
        super(_user);
        if (_user == null){ return; }
        this.name         = _user.name;
        this.sex          = _user.sex;
        this.onlineString = _user.last_online;
        this.listStats    = _user.stats.full_statuses;
        this.banned       = _user.banned;
        this.friend       = _user.in_friends;
        this.ignored      = _user.is_ignored;
    }*/

    public String getName() { return name; }

    public String getSex() {
        return sex;
    }

    public String getOnlineString() { return onlineString; }

    public _Statuses getListStats() { return listStats; }

    public boolean isBanned() {
        return banned;
    }

    public boolean isFriend() {
        return friend;
    }

    public boolean isIgnored() {
        return ignored;
    }

    public static User convertFromJsonModel(_UserFullInfo _user){
        if (_user == null){ return null; }

        User user = new User();
        user.id           = _user.id;
        user.nickname     = _user.nickname;
        user.avatar       = _user.image;
        user.lastOnline   = LocalDateTime.parse(_user.last_online_at, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX"));
        user.name         = _user.name;
        user.sex          = _user.sex;
        user.onlineString = _user.last_online;
        user.listStats    = _user.stats.full_statuses;
        user.banned       = _user.banned;
        user.friend       = _user.in_friends;
        user.ignored      = _user.is_ignored;
        return user;
    }
}
