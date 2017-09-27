package com.example.retrofit;

import android.view.View;
import android.widget.Toast;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by админ on 27.09.2017.
 */

public class ReceptManagerV2 {

    public void setInterface() {
        ReceptManager receptManager = new ReceptManager();
        receptManager.fetch(new ReceptInterface() {
            @Override
            public void ifSuccess(ResponseReceptes responseReceptes) {

            }

            @Override
            public void ifFailed() {

            }
        });
    }

}
