package ru.shikimori.api.models.userRate;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import ru.shikimori.api.constants.enums.TitleType;
import ru.shikimori.api.utils.DateUtils;

import java.time.LocalDateTime;

public class UserRateV2 extends UserRateShort {

    @SerializedName("user_id")
    @Expose
    private int userId;

    @SerializedName("target_id")
    @Expose
    private int targetId;

    @SerializedName("target_type")
    @Expose
    private String targetType;

    @SerializedName("created_at")
    @Expose
    private String createdDateTime;

    @SerializedName("updated_at")
    @Expose
    private String updatedDateTime;

    private UserRateV2(){}

    public int getUserId() {
        return userId;
    }

    public int getTargetId() {
        return targetId;
    }

    public TitleType getTargetType() {
        return TitleType.valueOf(targetType);
    }

    public LocalDateTime getCreatedDateTime() {
        return DateUtils.formatDateTimeFromString(createdDateTime);
    }

    public LocalDateTime getUpdatedDateTime() {
        return DateUtils.formatDateTimeFromString(updatedDateTime);
    }

}
