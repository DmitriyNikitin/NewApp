package com.example.newapp.Managers;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import static com.example.newapp.MainActivity.sPref;

/**
 * Created by админ on 08.09.2017.
 */

public class AuthManager {
     SharedPreferences sPref;
     SharedPreferences.Editor ed;
     String token = "Token";

    public String authManager = "auth";

    public AuthManager(Activity cnt){

        sPref = cnt.getSharedPreferences(authManager, Context.MODE_PRIVATE);
    }

    public void saveToken(String str){
        //// TODO: 08.09.2017 сохранить токен в preferenses

        ed = sPref.edit();
        ed.putString(token, str);
        ed.apply();
    }
    public String getToken(){
        //// TODO: 08.09.2017  получить токен из preferenses
        String retutnToken = sPref.getString(token, null);
        Log.d("","");
        return retutnToken;
    }
}
