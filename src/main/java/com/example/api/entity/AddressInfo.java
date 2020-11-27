package com.example.api.entity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import org.springframework.util.StringUtils;

import java.io.Serializable;


public class AddressInfo {
    private String addressId;

    private boolean defaultStatus;

    private String title;

    private String userId;

    private String userName;

    private String mobile;

    private String province;

    private String city;

    private String area;

    private String address;

    private String detail;

    private String latitude;

    private String longitude;

    public AddressInfo(){}

    public AddressInfo(String data){
        JSONObject address = JSON.parseObject(data);
        if(!StringUtils.isEmpty(address.get("addressId"))){
            this.addressId = address.get("addressId") + "";
        }
        this.title = address.get("title") + "";
        this.defaultStatus = address.getBoolean("defaultStatus");
        this.userId = address.get("userId") + "";
        this.userName = address.get("userName") + "";
        this.mobile = address.get("mobile") + "";
        if(null != address.get("province")){
            this.province = address.get("province") + "";
        }
        if(null != address.get("city")){
            this.city = address.get("city") + "";
        }
        if(null != address.get("area")){
            this.area = address.get("area") + "";
        }
        this.detail = address.get("detail") + "";
        this.address = address.get("address") + "";
        if(null != address.get("latitude")){
            this.latitude = address.get("latitude") + "";
        }
        if(null != address.get("longitude")){
            this.longitude = address.get("longitude") + "";
        }
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public boolean getDefaultStatus() {
        return defaultStatus;
    }

    public void setDefaultStatus(boolean defaultStatus) {
        this.defaultStatus = defaultStatus;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}