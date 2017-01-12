package com.example.changshuchao.httpconnectiondemo;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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

//        new HttpThread("https://www.ele.me/place/wtw3z2z66wb" , webView , handler).start();
//        new HttpThread("https://www.pgyer.com/" , webView , handler).start();
        new HttpThread("https://www.zhihu.com/" , webView , handler).start();
//        new HttpThread("http://www.baidu.com/" , webView , handler).start();

    }

    public void changeWeb(View view){
        //跳转新的界面
        startActivity(new Intent(MainActivity.this , WebActivity.class));
    }
}
