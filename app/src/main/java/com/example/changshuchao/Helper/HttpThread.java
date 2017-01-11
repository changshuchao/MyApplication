package com.example.changshuchao.Helper;

import android.os.Handler;
import android.webkit.WebView;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by changshuchao on 2017/1/11.
 * 网络访问是一个比较好事的操作所以最好放在Thread中
 */
public class HttpThread extends Thread{

    private String url;
    private WebView webView;
    private Handler handler;

    public HttpThread(String url, WebView webView, Handler handler) {
        this.url = url;
        this.webView = webView;
        this.handler = handler;
    }

    /*
    * 重写run（）方法
    * */
    @Override
    public void run() {
        try {
            URL httpurl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) httpurl.openConnection();//获得
            connection.setReadTimeout(5000);//设置访问网页超时的时间
            connection.setRequestMethod("GET");
            final StringBuffer stringBuffer = new StringBuffer();
            //connection.getInputStream() 网页回传的页面流的数据
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            //接受每一行的数据
            String str;
            while ((str =  bufferedReader.readLine()) != null){
                stringBuffer.append(str);
            }

            handler.post(new Runnable() {
                @Override
                public void run() {
                    /**
                     * loadData(String data, String mimeType, String encoding)
                     * data 网页信息
                     * mimeType 打开网页源代码 <meta http-equiv=Content-Type content="text/html;charset=utf-8">
                     * encoding
                     */
                    webView.loadData(stringBuffer.toString() , "text/html;charset=utf-8" , null);
                }
            });

        } catch (MalformedURLException e) {
            //描述这个url能否被解析的异常
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
