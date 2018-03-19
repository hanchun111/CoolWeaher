package com.example.hanchun.coolweather.db;

import org.litepal.crud.DataSupport;

/**
 * Created by hanchun on 2018/3/19.
 */

public class Province extends DataSupport {

    private  int id;

    private  String provinceName;

    private int provinceCode;

    public int getId(){
        return id;
    }

    public void setId(int n){
        this.id = n;
    }

    public String getProvinceName(){
        return this.provinceName;
    }

    public void setProvinceName(String name){
        this.provinceName = name;
    }

    public int getProvinceCode(){
        return this.provinceCode;
    }

    public void setProvinceCode(int code){
        this.provinceCode = code;
    }
}
