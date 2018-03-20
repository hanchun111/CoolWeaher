package com.example.hanchun.coolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by hanchun on 2018/3/20.
 */

public class Basic {

    @SerializedName("city")
    public String cityName;

    @SerializedName("id")
    public String weatherId;

    public Update update;

    public class Update{
        @SerializedName("loc")
        public String updateTime;
    }
}
