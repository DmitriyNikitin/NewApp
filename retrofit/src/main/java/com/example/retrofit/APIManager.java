package com.example.retrofit;

        import retrofit2.Retrofit;
        import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sergejromankov on 23.09.17.
 */

public class APIManager {
    private static APIManager instance;

    private final RequestInterface requestInterface;

    public static APIManager getInstance(){
        if(instance == null){
            instance = new APIManager();
        }
        return instance;
    }

    private APIManager(){

        Retrofit api = new Retrofit.Builder()
                .baseUrl("https://api.blagoyar.ru/")
//               .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
//              .client(httpClient.build())
                .build();

        this.requestInterface = api
                .create(RequestInterface.class);
    }



    public RequestInterface getRequestInterface() {
        return requestInterface;
    }
}

