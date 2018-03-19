package com.example.hanchun.coolweather.db;

import org.litepal.crud.DataSupport;

/**
 * Created by hanchun on 2018/3/19.
 */

public class City extends DataSupport {

    private  int id;

    private  String cityName;

    private int cityCode;

    private int ProvinceId;

    public int getId(){
        return this.id;
    }

    public  void setId(int id){
        this.id = id;
    }

    public  String getCityName(){
        return this.cityName;
    }

    public void setCityName(String name){
        this.cityName = name;
    }

    public int getCityCode(){
        return  this.cityCode;
    }

    public void setCityCode(int code){
        this.cityCode = code;
    }

    public int getProvinceId(){
        return  this.ProvinceId;
    }

    public void setProvinceId(int i){
        this.ProvinceId = i;
    }
}
