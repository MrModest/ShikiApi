package ru.shikimori.api.requests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import ru.shikimori.api.constants.ShikiConst;
import ru.shikimori.api.models.Client;
import ru.shikimori.api.models.Credential;
import ru.shikimori.api.models.exceptions.ErrorStack;

import java.io.IOException;
import java.util.Map;

public class QueryShell {

    private QueryShell(){}

    static {
        Unirest.setObjectMapper(new ObjectMapper() {
            private com.fasterxml.jackson.databind.ObjectMapper jacksonObjectMapper
                    = new com.fasterxml.jackson.databind.ObjectMapper();

            {
                jacksonObjectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            }

            public <T> T readValue(String value, Class<T> valueType) {
                try {
                    return jacksonObjectMapper.readValue(value, valueType);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            public String writeValue(Object value) {
                try {
                    return jacksonObjectMapper.writeValueAsString(value);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    } //static

    public static <T> T get(String url, Class<T> type){
        try {
            HttpResponse<String> response = Unirest
                    .get(ShikiConst.ROOT_API + url)
                    .header("User-Agent", Client.getUserAgent())
                    .asString();

            if (response.getStatus() != 200){
                ErrorStack.PushServerError(ShikiConst.ROOT_API + url, response.getStatus(), response.getStatusText());
                return null;
            }

            return new Gson().fromJson(response.getBody(), type);
        }
        catch (UnirestException | JsonSyntaxException ex){
            System.out.println(ex.getMessage());
            ErrorStack.PushLocalError("QueryShell.get()", ex.getMessage());
            return null;
        }
    }

    public static <T> T get(String url, Class<T> type, Credential credential){
        try {
            HttpResponse<String> response = Unirest
                    .get(ShikiConst.ROOT_API + url)
                    .header("X-User-Nickname", credential.getNickname())
                    .header("X-User-Api-Access-Token", credential.getToken())
                    .header("User-Agent", Client.getUserAgent())
                    .asString();

            if (response.getStatus() != 200){
                ErrorStack.PushServerError(ShikiConst.ROOT_API + url, response.getStatus(), response.getStatusText());
                return null;
            }

            return new Gson().fromJson(response.getBody(), type);
        }
        catch (UnirestException | JsonSyntaxException ex){
            ErrorStack.PushLocalError("QueryShell.get(credential)", ex.getMessage());
            return null;
        }
    }

    public static <T> T post(String url, Map<String, Object> postArgs, Class<T> type){
        try {
            HttpResponse<String> response = Unirest
                    .post(ShikiConst.ROOT_API + url)
                    .header("User-Agent", Client.getUserAgent())
                    .fields(postArgs)
                    .asString();

            if (response.getStatus() != 200){
                ErrorStack.PushServerError(ShikiConst.ROOT_API + url, response.getStatus(), response.getStatusText());
                return null;
            }

            return new Gson().fromJson(response.getBody(), type);
        }
        catch (UnirestException | JsonSyntaxException ex){
            ErrorStack.PushLocalError("QueryShell.post()", ex.getMessage());
            return null;
        }
    }

    public static <T> T post(String url, Map<String, Object> postArgs, Class<T> type, Credential credential){
        try {
            HttpResponse<String> response = Unirest
                    .post(ShikiConst.ROOT_API + url)
                    .header("X-User-Nickname", credential.getNickname())
                    .header("X-User-Api-Access-Token", credential.getToken())
                    .header("User-Agent", Client.getUserAgent())
                    .fields(postArgs)
                    .asString();

            if (response.getStatus() != 200){
                ErrorStack.PushServerError(ShikiConst.ROOT_API + url, response.getStatus(), response.getStatusText());
                return null;
            }

            return new Gson().fromJson(response.getBody(), type);
        }
        catch (UnirestException | JsonSyntaxException ex){
            ErrorStack.PushLocalError("QueryShell.post(credential)", ex.getMessage());
            return null;
        }
    }

    public static <T> T put(String url, Map<String, Object> putArgs, Class<T> type){
        try {
            HttpResponse<String> response = Unirest
                    .put(ShikiConst.ROOT_API + url)
                    .header("User-Agent", Client.getUserAgent())
                    .fields(putArgs)
                    .asString();

            if (response.getStatus() != 200){
                ErrorStack.PushServerError(ShikiConst.ROOT_API + url, response.getStatus(), response.getStatusText());
                return null;
            }

            return new Gson().fromJson(response.getBody(), type);

        }
        catch (UnirestException | JsonSyntaxException ex){
            ErrorStack.PushLocalError("QueryShell.put()", ex.getMessage());
            return null;
        }
    }

    public static <T> T put(String url, Map<String, Object> putArgs, Class<T> type, Credential credential){
        try {
            HttpResponse<String> response = Unirest
                    .put(ShikiConst.ROOT_API + url)
                    .header("X-User-Nickname", credential.getNickname())
                    .header("X-User-Api-Access-Token", credential.getToken())
                    .header("User-Agent", Client.getUserAgent())
                    .fields(putArgs)
                    .asString();

            if (response.getStatus() != 200){
                ErrorStack.PushServerError(ShikiConst.ROOT_API + url, response.getStatus(), response.getStatusText());
                return null;
            }

            return new Gson().fromJson(response.getBody(), type);

        }
        catch (UnirestException | JsonSyntaxException ex){
            ErrorStack.PushLocalError("QueryShell.put(credential)", ex.getMessage());
            return null;
        }
    }

    public static boolean delete(String url){
        try {
            HttpResponse<String> response = Unirest
                    .delete(ShikiConst.ROOT_API + url)
                    .header("User-Agent", Client.getUserAgent())
                    .asString();

            if (response.getStatus() != 200 || response.getStatus() != 204){
                ErrorStack.PushServerError(ShikiConst.ROOT_API + url, response.getStatus(), response.getStatusText());
            }

            return response.getStatus() == 200 || response.getStatus() == 204;
        }
        catch (UnirestException | JsonSyntaxException ex){
            ErrorStack.PushLocalError("QueryShell.delete()", ex.getMessage());
            return false;
        }
    }

    public static boolean delete(String url, Credential credential){
        try {
            HttpResponse<String> response = Unirest
                    .delete(ShikiConst.ROOT_API + url)
                    .header("X-User-Nickname", credential.getNickname())
                    .header("X-User-Api-Access-Token", credential.getToken())
                    .header("User-Agent", Client.getUserAgent())
                    .asString();

            if (response.getStatus() != 200 || response.getStatus() != 204){
                ErrorStack.PushServerError(ShikiConst.ROOT_API + url, response.getStatus(), response.getStatusText());
            }

            return response.getStatus() == 200 || response.getStatus() == 204;
        }
        catch (UnirestException | JsonSyntaxException ex){
            ErrorStack.PushLocalError("QueryShell.delete(credential)", ex.getMessage());
            return false;
        }
    }
}
