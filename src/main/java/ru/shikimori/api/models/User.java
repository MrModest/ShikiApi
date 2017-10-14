package ru.shikimori.api.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import ru.shikimori.api.models.json._Stats;
import ru.shikimori.api.models.json._Statuses;

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

    private User(){}

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

}
