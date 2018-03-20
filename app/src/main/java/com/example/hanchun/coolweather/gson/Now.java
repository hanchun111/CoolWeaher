package com.example.hanchun.coolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by hanchun on 2018/3/20.
 */

public class Now {

    @SerializedName("tmp")
    public  String temperature;

    @SerializedName("cond")
    public  More more;

    public class More{

        @SerializedName("txt")
        public String info;
    }
}
