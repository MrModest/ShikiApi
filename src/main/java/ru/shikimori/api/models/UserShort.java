package ru.shikimori.api.models;

import ru.shikimori.api.models.json._ImageUser;
import ru.shikimori.api.models.json._UserShortInfo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UserShort {

    private int id;
    private String nickname;
    private _ImageUser avatar;
    private LocalDateTime lastOnline;

    public UserShort(){}

    public UserShort(_UserShortInfo _userShort){
        if (_userShort == null){ return; }
        this.id           = _userShort.id;
        this.nickname     = _userShort.nickname;
        this.avatar       = _userShort.image;
        this.lastOnline   = LocalDateTime.parse(_userShort.last_online_at, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX"));
    }

    public int getId(){
        return id;
    }

    public String getNickname() { return nickname; }

    public _ImageUser getAvatar() {
        return avatar;
    }

    public LocalDateTime getLastOnline() {
        return lastOnline;
    }

    public User getUser() {
        return User.getUserById(this.id);
    }

    public static UserShort convertFromJsonModel(_UserShortInfo _userShort){
        if (_userShort == null){ return null; }

        UserShort userShort = new UserShort();
        userShort.id           = _userShort.id;
        userShort.nickname     = _userShort.nickname;
        userShort.avatar       = _userShort.image;
        userShort.lastOnline   = LocalDateTime.parse(_userShort.last_online_at, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX"));
        return userShort;
    }
}
