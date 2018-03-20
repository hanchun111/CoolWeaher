package com.example.hanchun.coolweather.util;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by hanchun on 2018/3/19.
 */

public class HttpUtil {
    public static  void sendokHttpRequest(String address,okhttp3.Callback callback){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(address).build();
        client.newCall(request).enqueue(callback);
    }
}
