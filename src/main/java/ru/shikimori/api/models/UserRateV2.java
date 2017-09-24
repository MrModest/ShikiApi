package ru.shikimori.api.models;

import ru.shikimori.api.constants.enums.TitleProgressStatus;
import ru.shikimori.api.constants.enums.TitleType;
import ru.shikimori.api.models.json._UserRateV2;
import ru.shikimori.api.utils.DateUtils;

import java.time.LocalDateTime;

public class UserRateV2 extends UserRateShort {

    private int userId;
    private int targetId;
    private TitleType targetType;
    private LocalDateTime createdDateTime;
    private LocalDateTime updatedDateTime;

    private UserRateV2(){}

    public int getUserId() {
        return userId;
    }

    public int getTargetId() {
        return targetId;
    }

    public TitleType getTargetType() {
        return targetType;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public LocalDateTime getUpdatedDateTime() {
        return updatedDateTime;
    }


    public static UserRateV2 convertFromJsonModel(_UserRateV2 _userRate){
        if (_userRate == null) { return null; }

        UserRateV2 userRate = new UserRateV2();
        userRate.id = _userRate.id;
        userRate.score = _userRate.score;
        userRate.status = _userRate.status;
        userRate.text = _userRate.text;
        userRate.episodes = _userRate.episodes;
        userRate.chapters = _userRate.chapters;
        userRate.volumes = _userRate.volumes;
        userRate.textHtml = _userRate.text_html;
        userRate.rewatches = _userRate.rewatches;

        userRate.userId = _userRate.user_id;
        userRate.targetId = _userRate.target_id;
        userRate.targetType = TitleType.valueOf(_userRate.target_type);
        userRate.createdDateTime = DateUtils.formatDateTimeFromString(_userRate.created_at);
        userRate.updatedDateTime = DateUtils.formatDateTimeFromString(_userRate.updated_at);

        return userRate;
    }

    public static UserRateV2[] convertFromJsonModel(_UserRateV2[] _userRates){
        if (_userRates == null || _userRates.length == 0) { return null; }

        UserRateV2[] userRates = new UserRateV2[_userRates.length];
        for (int i = 0; i < _userRates.length; i++){
            userRates[i] = UserRateV2.convertFromJsonModel(_userRates[i]);
        }

        return userRates;
    }
}
