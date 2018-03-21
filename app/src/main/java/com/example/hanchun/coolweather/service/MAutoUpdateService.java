package com.example.hanchun.coolweather.service;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.util.Log;

import com.example.hanchun.coolweather.gson.Weather;
import com.example.hanchun.coolweather.util.HttpUtil;
import com.example.hanchun.coolweather.util.Utility;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MAutoUpdateService extends Service {
    public MAutoUpdateService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return null;
    }

    @Override
    public int onStartCommand(Intent intent , int flags , int startId){
        updateWeather();
        updateBngPic();
        AlarmManager manager = (AlarmManager) getSystemService(ALARM_SERVICE);
        int anhour = 8*60*60*1000;
        long triggerAtTime = SystemClock.elapsedRealtime() + anhour;
        Intent i = new Intent(this , MAutoUpdateService.class);
        PendingIntent pi = PendingIntent.getService(this,0,i,0);
        manager.cancel(pi);
        manager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,triggerAtTime,pi);
        return super.onStartCommand(intent,flags,startId);
    }

    /**
     *
     * 更新天气到preference
     */

    private void updateWeather(){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String weatherString  = prefs.getString("weather",null);

        if(weatherString != null){
            Weather weather = Utility.handleWeatherResponse(weatherString);
            String weatherId = weather.basic.weatherId;

            String weatherUrl = "http://guolin.tech/api/weather?cityid="+weatherId+"&key=ee68e520be2f496ea00c96dddf17082a";

            HttpUtil.sendokHttpRequest(weatherUrl, new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    e.printStackTrace();
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    String responseText = response.body().string();
                    Weather weather = Utility.handleWeatherResponse(responseText);
                    if(weather != null && "ok".equals(weather.status)){
                        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(MAutoUpdateService.this).edit();
                        editor.putString("weather",responseText);
                        editor.apply();
                    }

                }
            });
        }
    }

    /**
     *
     * 更新必应每日一图
     */

    private void updateBngPic(){
        final String requestBingPic = "http://guolin.tech/api/bing_pic";
        HttpUtil.sendokHttpRequest(requestBingPic, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String bingPic = response.body().string();
                SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(MAutoUpdateService.this).edit();
                Log.d("bing_pic",bingPic);
                editor.putString("bing_pic",bingPic);
                editor.apply();
            }
        });
    }
}
