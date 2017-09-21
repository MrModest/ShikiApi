package ru.shikimori.api.models;

import org.apache.commons.lang3.StringUtils;
import ru.shikimori.api.constants.ShikiConst;

public class Client {

    public static String name = ShikiConst.DEFAULT_CLIENT_NAME;
    public static String clientVersion;
    public static String apiVersion;

    private Client(){}

    public static String getUserAgent(){
        String userAgent = name;

        if (StringUtils.isNotBlank(clientVersion)){
            userAgent += " " + clientVersion;
        }

        if (StringUtils.isNotBlank(apiVersion)){
            userAgent += " " + apiVersion;
        }

        return userAgent;
    }
}
