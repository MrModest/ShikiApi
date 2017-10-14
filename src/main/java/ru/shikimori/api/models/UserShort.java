package ru.shikimori.api.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import ru.shikimori.api.constants.ShikiConst;
import ru.shikimori.api.constants.enums.TitleType;
import ru.shikimori.api.models.exceptions.ErrorStack;
import ru.shikimori.api.requests.QueryShell;
import ru.shikimori.api.utils.DateUtils;

import java.time.LocalDateTime;

public class UserShort {

    @SerializedName("id")
    @Expose
    protected int id;

    @SerializedName("nickname")
    @Expose
    protected String nickname;

    @SerializedName("image")
    @Expose
    protected UserImage avatar;

    @SerializedName("last_online_at")
    @Expose
    protected String lastOnline;

    protected UserShort(){}

    public int getId(){
        return id;
    }

    public String getNickname() { return nickname; }

    public UserImage getAvatar() {
        return avatar;
    }

    public LocalDateTime getLastOnline() {
        return DateUtils.formatDateTimeFromString(lastOnline);
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
        User user = QueryShell.get("users/" + userId, User.class);
        return user;
    }

    public static User getUserByCredential(Credential credential){
        return getUserById(credential.getId());
    }

    public static UserShort[] getFriendsById(int userId) throws NullPointerException {

        UserShort[] friendList;

        try {
            friendList = QueryShell.get("users/" + userId + "/friends", UserShort[].class);
        }
        catch (NullPointerException ex){
            ErrorStack.PushLocalError("User.getFriendsById()", ex.getMessage() + " (probably user not found or too many requests [404 or 429])");
            throw ex;
        }

        return friendList;
    }

    public static UserRate[] getUserRatesById(int user_id, TitleType titleType){
        String url = "users/" + user_id + "/" + titleType.name().toLowerCase() + "_rates?limit=" + ShikiConst.LIMIT_MAX;
        UserRate[] userRates = QueryShell.get(url, UserRate[].class);
        return userRates;
    }

}
