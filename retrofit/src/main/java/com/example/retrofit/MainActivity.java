package com.example.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {

    public ListView listView;
    public TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        listView = (ListView)findViewById(R.id.list);
        textView =(TextView)findViewById(R.id.Error);
        ReceptManager rM = new ReceptManager();
        rM.fetch(new ReceptInterface() {
            @Override
            public void ifSuccess(ResponseReceptes responseReceptes) {
                if(responseReceptes.getData().getRecipes() != null)
                {

                    CustomListAdapter adapter = new CustomListAdapter(MainActivity.this, responseReceptes.getData().getRecipes());
                    listView.setAdapter(adapter);
                    textView.setVisibility(View.INVISIBLE);
                }else{
                   textView.setVisibility(View.VISIBLE);

                }
            }

            @Override
            public void ifFailed() {
                Toast.makeText(MainActivity.this, "Проверьте соединение с сетью", Toast.LENGTH_LONG).show();
            }
        });



        //TODO: Нужно перенести это в проект выше, то есть эти данные нужно вывести это в списке

    }
}
