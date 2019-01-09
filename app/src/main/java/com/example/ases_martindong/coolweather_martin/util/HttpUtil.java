package com.example.ases_martindong.coolweather_martin.util;

import android.util.Log;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpUtil {
   public static void sendOkHttpRequest(String address, okhttp3.Callback callback){
       OkHttpClient client = new OkHttpClient();
       //client.writeTimeoutMillis();
       Request request = new Request.Builder().url(address).get().build();
       client.newCall(request).enqueue(callback);
    }
}

