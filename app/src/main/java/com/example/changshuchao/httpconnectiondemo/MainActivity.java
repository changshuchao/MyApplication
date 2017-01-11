package com.example.changshuchao.httpconnectiondemo;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.example.changshuchao.Helper.HttpThread;

public class MainActivity extends AppCompatActivity {

    private WebView webView;
    private Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = (WebView)findViewById(R.id.webview);

        new HttpThread("www.baidu.com" , webView , handler);
    }
}
