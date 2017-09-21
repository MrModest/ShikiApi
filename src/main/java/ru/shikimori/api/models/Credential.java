package ru.shikimori.api.models;

import org.apache.commons.lang3.StringUtils;

import ru.shikimori.api.models.exceptions.ErrorStack;
import ru.shikimori.api.models.json._AccessToken;
import ru.shikimori.api.models.json._WhoAmI;
import ru.shikimori.api.requests.QueryShell;

import java.util.HashMap;
import java.util.Map;

public class Credential {

    private int id;
    private String nickname;
    private String token;
    private User currentUser;

    public Credential(String nickname, String password) {

        this.token = getAccessToken(nickname, password);
        if (StringUtils.isBlank(this.token)){
            return;
        }

        this.nickname = nickname;

        this.id = getUserId(nickname, token);

        this.currentUser = User.getUserByCredential(this);
    }

    public Credential(String nickname, String token, int id){
        this.id = id;
        this.nickname = nickname;
        this.token = token;
        this.currentUser = User.getUserByCredential(this);
    }

    public int getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public String getToken() {
        return token;
    }

    public User getCurrentUser() { return currentUser; }

    public boolean isLoginSuccess(){
        return StringUtils.isNotBlank(this.token) && this.id >= 0;
    }

    private static String getAccessToken(String nickname, String password){
        try {
            Map<String, Object> postArgs = new HashMap<>();
            postArgs.put("nickname", nickname);
            postArgs.put("password", password);
            return QueryShell.post("access_token", postArgs, _AccessToken.class).api_access_token;
        }
        catch (Exception ex){
            ErrorStack.PushLocalError("Credential.getAccessToken()", ex.getMessage());
            return null;
        }
    }

    private static int getUserId(String nickname, String token) {
        try {
            return QueryShell.get("users/whoami", _WhoAmI.class, new Credential(nickname, token, -1)).id;
        }
        catch (Exception ex){
            ErrorStack.PushLocalError("Credential.getUserId()", ex.getMessage());
            return -1;
        }
    }
}
