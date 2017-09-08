package com.example.newapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.newapp.Managers.AuthManager;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static SharedPreferences sPref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button)findViewById(R.id.button);
    //// TODO: 08.09.2017 Создать объект authManager
        AuthManager authManager = new AuthManager(this);
        //запросить у authmanager токен

        // если токен существует пользователь авторизован
      if(authManager.getToken() != null) {
            //показать Toast пользователь авторизован
           Toast.makeText(this, "Пользователь авторизован.", Toast.LENGTH_LONG).show();
        }
            button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                Intent intent = new Intent(this, WebViewActivity.class);
                startActivity(intent);

        }
    }
}
