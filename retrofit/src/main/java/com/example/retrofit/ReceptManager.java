package com.example.retrofit;

import android.content.Context;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by админ on 26.09.2017.
 */

public class ReceptManager {


    MainActivity mainActivity;

    public ReceptManager(MainActivity mainActivity){

        this.mainActivity = mainActivity;

    }

        String udid = "romankov.sergey1@gmail.com";
        String client = "QSxm8ptMGjXFK7jxl5-zog";
        String access_token = "jby65dq84_yk0IXYdEofeg";
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\r\n\"page\": 1,\r\n\"per_page\": 20, \r\n\"is_main\": false}");



    public void fetch(){
        APIManager.getInstance().getRequestInterface().getRecipes(udid , client, access_token, body).enqueue(new Callback<ResponseReceptes>() {
            @Override
            public void onResponse(Call<ResponseReceptes> call, Response<ResponseReceptes> response) {
                ResponseReceptes recep = response.body();
                if(recep.getData().getRecipes() != null)
                {

                    CustomListAdapter adapter = new CustomListAdapter(mainActivity, recep.getData().getRecipes());
                    mainActivity.listView.setAdapter(adapter);
                    mainActivity.findViewById(R.id.Error).setVisibility(View.INVISIBLE);
                }else{
                    mainActivity.findViewById(R.id.Error).setVisibility(View.VISIBLE);

                }
            }

            @Override
            public void onFailure(Call<ResponseReceptes> call, Throwable t) {
                Toast.makeText(mainActivity, "Проверьте связь с сетью.", Toast.LENGTH_LONG).show();
            }
        });
    }


}
