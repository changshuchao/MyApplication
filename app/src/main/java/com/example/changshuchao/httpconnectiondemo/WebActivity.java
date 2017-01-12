package com.example.changshuchao.httpconnectiondemo;

import android.net.http.SslError;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        webView = (WebView)findViewById(R.id.webview);
        webView.setWebViewClient(new WebViewClient() {
            public void onReceivedSslError(WebView view,
                                           SslErrorHandler handler, SslError error) {
                // 　　//handler.cancel(); 默认的处理方式，WebView变成空白页
                handler.proceed(); // 接受证书
                // handleMessage(Message msg); 其他处理
            }
        });
        //启用支持javascript
        WebSettings settings = webView.getSettings();

        // 这两行代码一定加上否则效果不会出现
        settings.setJavaScriptEnabled(true);
        settings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        settings.setDefaultTextEncodingName("gb2312");
        webView.loadUrl("https://114.255.225.50:8088/icbc/roa/sy/base/view/stdCardView.jsp?sId=PE_APPLICATION_INFO&pkCode=2xejSQZFx4H8F5J0IEKb&replaceUrl=PE_APPLICATION_INFO.byid.do?data={_PK_:2xejSQZFx4H8F5J0IEKb,NI_ID:01RgbJMh10eoICkXhptk}&encUserInfo=%2Fs8DFq9CamKGdzFqBVVwRQ%3D%3D&_SUPMOBILE_=1");

        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                // TODO Auto-generated method stub
                if (newProgress == 100) {
                    // 网页加载完成

                } else {
                    // 加载中

                }

            }
        });

    }

    //改写物理按键——返回的逻辑
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if(keyCode==KeyEvent.KEYCODE_BACK)
        {
            if(webView.canGoBack())
            {
                webView.goBack();//返回上一页面
                return true;
            }
            else
            {
                System.exit(0);//退出程序
            }
        }
        return super.onKeyDown(keyCode, event);
    }


}
