package com.example.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {

    private WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webview = findViewById(R.id.wvInstruction);

        String htmlString = "<h1>Hello World</h1>";
        //webview.loadData(htmlString, "text/html", "utf8");

       // webview.loadUrl("https://www.google.com");
        webview.setWebViewClient(new WebViewClient());

        AssetManager assetManager = this.getAssets();
        try {
            InputStream inputStream = assetManager.open("test.html");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            String content = new String(buffer, StandardCharsets.UTF_8);
            Log.d("DATA", content);
            webview.loadData(content,"text/html","utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
