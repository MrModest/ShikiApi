package ru.shikimori.api.models.title;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import ru.shikimori.api.constants.enums.AnimeKind;
import ru.shikimori.api.constants.enums.TitleReleaseStatus;
import ru.shikimori.api.models.TitleImage;
import ru.shikimori.api.utils.DateUtils;

import java.time.LocalDate;

public abstract class TitleShort {

    @SerializedName("id")
    @Expose
    protected int id;

    @SerializedName("name")
    @Expose
    protected String name;

    @SerializedName("russian")
    @Expose
    protected String russian;

    @SerializedName("image")
    @Expose
    protected TitleImage image;

    @SerializedName("url")
    @Expose
    protected String url;

    @SerializedName("kind")
    @Expose
    protected String kind;

    @SerializedName("status")
    @Expose
    protected String releaseStatus;

    @SerializedName("aired_on")
    @Expose
    protected String airedDate;

    @SerializedName("released_on")
    @Expose
    protected String releasedDate;

    //protected TitleShort(){}

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRussian() {
        return russian;
    }

    public TitleImage getImage() {
        return image;
    }

    public String getUrl() {
        return url;
    }

    public Object getKind() {
        return kind;
    }

    public TitleReleaseStatus getReleaseStatus() {
        return TitleReleaseStatus.valueOf(releaseStatus);
    }

    public LocalDate getAiredDate() {
        return DateUtils.formatDateFromString(airedDate);
    }

    public LocalDate getReleasedDate() {
        return DateUtils.formatDateFromString(releasedDate);
    }

    @Override
    public boolean equals(Object other){
        if (other == null) return false;
        if (other == this) return true;
        if (this.getClass() != other.getClass()) return false;

        try {
            TitleShort otherTitleShort = (TitleShort) other;
            return this.id == otherTitleShort.id;
        }
        catch (Exception ex){
            return false;
        }
    }

}