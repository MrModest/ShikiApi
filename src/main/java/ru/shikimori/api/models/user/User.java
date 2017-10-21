package ru.shikimori.api.models.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import ru.shikimori.api.constants.ShikiConst;
import ru.shikimori.api.constants.enums.TitleType;
import ru.shikimori.api.models.Credential;
import ru.shikimori.api.models.exceptions.ErrorStack;
import ru.shikimori.api.models.json._Stats;
import ru.shikimori.api.models.json._Statuses;
import ru.shikimori.api.models.userRate.UserRate;
import ru.shikimori.api.requests.QueryShell;

public class User extends UserShort {

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("sex")
    @Expose
    private String sex;

    @SerializedName("last_online")
    @Expose
    private String onlineString;

    @SerializedName("stats")
    @Expose
    private _Stats listStats;

    @SerializedName("banned")
    @Expose
    private boolean banned;

    @SerializedName("in_friends")
    @Expose
    private boolean friend;

    @SerializedName("is_ignored")
    @Expose
    private boolean ignored;

    //private User(){}

    public String getName() { return name; }

    public String getSex() {
        return sex;
    }

    public String getOnlineString() { return onlineString; }

    public _Statuses getListStats() { return listStats.full_statuses; }

    public boolean isBanned() {
        return banned;
    }

    public boolean isFriend() {
        return friend;
    }

    public boolean isIgnored() {
        return ignored;
    }

    public static User getById(int userId){
        if (userId < 0){ return null; }
        return QueryShell.get("users/" + userId, User.class);
    }

    public static User getByCredential(Credential credential){
        return getById(credential.getId());
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
        String url = "users/" + user_id + "/" + titleType.name().toLowerCase() + "_rates?limitOnPage=" + ShikiConst.LIMIT_MAX;
        return QueryShell.get(url, UserRate[].class);
    }

}
