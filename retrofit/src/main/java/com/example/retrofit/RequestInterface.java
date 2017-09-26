package com.example.retrofit;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by админ on 25.09.2017.
 */

    public interface RequestInterface {



    @POST("/v1/recipes")
    Call<ResponseReceptes> getRecipes(
            @Header("uid") String uid,
            @Header("client") String client,
            @Header("access-token") String accessToken,
            @Body RequestBody body
    );

}

