package com.example.newapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class WebViewActivity extends AppCompatActivity {

    public  final String host_authorize = "https://oauth.vk.com/authorize",
            client_id = "client_id=6043385",
            display = "display=mobile",
            redirect_uri = "redirect_uri=https://oauth.vk.com/blank.html",
            scope = "scope=friends,offline",
            response_type = "response_type=token",
            version = "v=5.65",
            revoke = "revoke=1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        WebView webView = (WebView)findViewById(R.id.web);
        webView.setWebViewClient(new CustomWebViewClient(this));

        String authorize = host_authorize + "?" + client_id + "&" + display + "&" + redirect_uri + "&" + scope + "&" + response_type + "&" + version + "&" + revoke;

        webView.loadUrl(authorize);


    }

}
