package com.example.ea6news;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class webView extends AppCompatActivity {

    WebView webView;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        getSupportActionBar().hide();
    }

    @Override
    protected void onStart() {
        super.onStart();

        webView = findViewById(R.id.webView);
        imageView = findViewById(R.id.gifImageView);
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url);

        webView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View view, int i, int i1, int i2, int i3) {
                if(webView.getLayoutParams().height != 2560){
                    webView.getLayoutParams().height += 20;
                    imageView.getLayoutParams().height -= 20;
                    imageView.requestLayout();
                }
            }
        });
    }
}