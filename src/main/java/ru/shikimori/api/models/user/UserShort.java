package ru.shikimori.api.models.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import ru.shikimori.api.constants.enums.TitleType;
import ru.shikimori.api.models.UserImage;
import ru.shikimori.api.models.userRate.UserRate;
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

    //protected UserShort(){}

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
        return User.getById(this.id);
    }

    public UserShort[] getFriends() {
        return User.getFriendsById(this.id);
    }

    public UserRate[] getUserRates(TitleType titleType){
        return User.getUserRatesById(this.id, titleType);
    }

    @Override
    public boolean equals(Object other){
        if (other == null) return false;
        if (other == this) return true;

        try {
            UserShort otherTitleShort = (UserShort) other;
            return this.id == otherTitleShort.id;
        }
        catch (Exception ex){
            return false;
        }
    }

}
