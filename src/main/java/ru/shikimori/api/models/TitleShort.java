package ru.shikimori.api.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
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
    protected String status;

    @SerializedName("aired_on")
    @Expose
    protected String airedDate;

    @SerializedName("released_on")
    @Expose
    protected String releasedDate;

    protected TitleShort(){}

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

    public String getKind() {
        return kind;
    }

    public String getStatus() {
        return status;
    }

    public LocalDate getAiredDate() {
        return DateUtils.formatDateFromString(airedDate);
    }

    public LocalDate getReleasedDate() {
        return DateUtils.formatDateFromString(releasedDate);
    }

}