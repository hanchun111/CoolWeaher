package com.example.hanchun.coolweather.db;

import org.litepal.crud.DataSupport;

/**
 * Created by hanchun on 2018/3/19.
 */

public class County extends DataSupport {

    private  int id;

    private  String countyName;

    private String weatherId;

    private int cityId;

    public int getId(){
        return this.id;
    }

    public void setId(int i){
        this.id = i;
    }

    public String getCountyname(){
        return this.countyName;
    }

    public void setCountyName(String name){
        this.countyName = name;
    }

    public String getWeatherId(){
        return  this.weatherId;
    }

    public void setWeatherId(String weatherId){
        this.weatherId = weatherId;
    }

    public int getCityId(){
        return  this.cityId;
    }

    public void setCityId(int i){
        this.cityId = i;
    }

}
