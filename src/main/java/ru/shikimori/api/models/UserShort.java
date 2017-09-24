package ru.shikimori.api.models;

import org.apache.commons.lang3.StringUtils;
import ru.shikimori.api.constants.ShikiConst;
import ru.shikimori.api.constants.enums.TitleType;
import ru.shikimori.api.models.exceptions.ErrorStack;
import ru.shikimori.api.models.json._ImageUser;
import ru.shikimori.api.models.json._UserFullInfo;
import ru.shikimori.api.models.json._UserRate;
import ru.shikimori.api.models.json._UserShortInfo;
import ru.shikimori.api.requests.QueryShell;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UserShort {

    protected int id;
    protected String nickname;
    protected _ImageUser avatar;
    protected LocalDateTime lastOnline;

    protected UserShort(){}

    /*public UserShort(_UserShortInfo _userShort){
        if (_userShort == null){ return; }
        this.id           = _userShort.id;
        this.nickname     = _userShort.nickname;
        this.avatar       = _userShort.image;
        this.lastOnline   = LocalDateTime.parse(_userShort.last_online_at, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX"));
    }*/

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

    public UserShort[] getFriends() {
        return getFriendsById(this.id);
    }

    public UserRate[] getUserRates(TitleType titleType){
        return getUserRatesById(this.id, titleType);
    }


    public static User getUserById(int userId){
        if (userId < 0){ return null; }
        _UserFullInfo _user = QueryShell.get("users/" + userId, _UserFullInfo.class);
        return User.convertFromJsonModel(_user);
    }

    public static User getUserByCredential(Credential credential){
        return getUserById(credential.getId());
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
            friendList[i] = UserShort.convertFromJsonModel(_friendList[i]);
        }

        return friendList;
    }

    public static UserRate[] getUserRatesById(int user_id, TitleType titleType){
        String url = "users/" + user_id + "/" + titleType.name().toLowerCase() + "_rates?limit=" + ShikiConst.LIMIT_MAX;
        _UserRate[] _userRates = QueryShell.get(url, _UserRate[].class);
        return UserRate.convertFromJsonModel(_userRates);
    }

    public static UserShort convertFromJsonModel(_UserShortInfo _userShort){
        if (_userShort == null){ return null; }

        UserShort userShort = new UserShort();
        userShort.id           = _userShort.id;
        userShort.nickname     = _userShort.nickname;
        userShort.avatar       = _userShort.image;
        userShort.lastOnline   = StringUtils.isNotBlank(_userShort.last_online_at) ? LocalDateTime.parse(_userShort.last_online_at, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX")) : null;

        return userShort;
    }
}
