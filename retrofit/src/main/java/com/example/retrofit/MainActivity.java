package com.example.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {




    private String URL = "https://api.blagoyar.ru";

    private Gson gson = new GsonBuilder().create();

    private Retrofit retrofit = new Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(URL)
            .build();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Link intf = retrofit.create(Link.class);
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\r\n\"page\": 1,\r\n\"per_page\": 20, \r\n\"is_main\": false}");
        Request request = new Request.Builder()
                .url("http://api.blagoyar.ru/v1/recipes")
                .post(body)
                .addHeader("access-token", "6scvSWQGWJupF1x1cp8ZXw")
                .addHeader("cache-control", "no-cache")
                .addHeader("client", "jMAcbB8dHizcPajSyCp3eg")
                .addHeader("content-type", "application/json")
                .addHeader("expiry", "1507020023")
                .addHeader("host", "api.blagoyar.ru")
                .addHeader("postman-token", "7df8bb7a-65fc-582e-feed-ffbc8b8a9019")
                .addHeader("token-type", "Bearer")
                .addHeader("uid", "mimitest3@list.ru")
                .build();

        Call<Object> call = intf.resipes(request);
        try {
            Response<Object> response = call.execute();
        /*    Map<String,String> map = gson.fromJson(response.body().toString(),Map.class);
            for(Map.Entry e : map.entrySet()) {
                System.out.println(e.getKey()+" "+ e.getValue());
            }*/
            }
           catch (IOException e) {
            e.printStackTrace();
        }

    }
}
