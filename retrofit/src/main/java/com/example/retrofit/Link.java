package com.example.retrofit;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Map;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by админ on 21.09.2017.
 */

public interface Link {

    @FormUrlEncoded
    @POST("/v1/recipes")
    Call<Object> resipes(@Field("response") Request request);


}
