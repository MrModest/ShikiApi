package ru.shikimori.api.models;

import ru.shikimori.api.models.exceptions.ErrorStack;
import ru.shikimori.api.models.json._Statuses;
import ru.shikimori.api.models.json._UserFullInfo;
import ru.shikimori.api.models.json._UserShortInfo;
import ru.shikimori.api.requests.QueryShell;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class User extends UserShort {

    //private int id;
    //private String nickname;
    private String name;
    private String sex;
    //private _ImageUser avatar;
    //private LocalDateTime lastOnline;
    private String onlineString;
    private _Statuses listStats;
    private boolean banned;
    private boolean friend;
    private boolean ignored;

    public User(){}

    public User(_UserFullInfo _user) {
        super(_user);
        if (_user == null){ return; }
        convertFromJsonModel(_user);
    }

    //public int getId(){ return id; }

    //public String getNickname() { return nickname; }

    public String getName() { return name; }

    public String getSex() {
        return sex;
    }

    //public _ImageUser getAvatar() { return avatar; }

    //public LocalDateTime getLastOnline() { return lastOnline; }

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

    public static User getUserById(int userId){
        if (userId < 0){ return null; }
        _UserFullInfo _user = QueryShell.get("users/" + userId, _UserFullInfo.class);
        if (_user == null){ return null; }
        return new User(_user);
    }

    public static User getUserByCredential(Credential credential){
        return getUserById(credential.getId());
    }

    public UserShort[] getFriends() {
        return getFriendsById(this.getId());
    }

    public static UserShort[] getFriendsById(int userId) throws NullPointerException {

        _UserShortInfo[] _friendList;

        try {
            _friendList = QueryShell.get("users/" + userId + "/friends", _UserShortInfo[].class);
        }
        catch (NullPointerException ex){
            ErrorStack.PushLocalError("User.getFriendsById()", ex.getMessage() + " (probably user not found or too many requests [404 or 429])");
            throw ex;
        }

        UserShort[] friendList = new UserShort[_friendList.length];

        for (int i = 0; i < _friendList.length; i++){
            friendList[i] = new UserShort(_friendList[i]);
        }

        return friendList;
    }

    private void convertFromJsonModel(_UserFullInfo _user){
        //this.id           = _user.id;
        //this.nickname     = _user.nickname;
        this.name         = _user.name;
        this.sex          = _user.sex;
        //this.avatar       = _user.image;
        //this.lastOnline   = LocalDateTime.parse(_user.last_online_at, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX"));
        this.onlineString = _user.last_online;
        this.listStats    = _user.stats.full_statuses;
        this.banned       = _user.banned;
        this.friend       = _user.in_friends;
        this.ignored      = _user.is_ignored;
    }
}
