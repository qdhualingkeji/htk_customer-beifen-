package com.hl.htk_customer.model;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * Created by Administrator on 2017/6/26.
 */

public class DefaultAddress {

    private int addressId = -1;
    private String userName = "";
    private int sex = 0; //0 女士  1男士
    private String location = "";
    private String address = "";
    private long phoneNumber;
    private float longitude;
    private float latitude;

    /**
     * @author 马鹏昊
     * @desc 判断当前用户是否是上次保存地址信息的用户时用到
     * @date 2018-4-24
     */
    private String token;

    public String getToken() {
        return mSharedPreferences.getString("savedToken", "");
    }

    public void setToken(String token) {
        this.token = token;
        mEditor.putString("savedToken", token);
        mEditor.commit();
    }

    Context mContext;
    SharedPreferences mSharedPreferences;
    SharedPreferences.Editor mEditor;

    public DefaultAddress(Context mContext) {
        this.mContext = mContext;
        mSharedPreferences = mContext.getSharedPreferences("saveinfo", Activity.MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();
    }

    public int getAddressId() {
        addressId = mSharedPreferences.getInt("addressId",-1);
        return addressId;
    }

    public void setAddressId(int addressId) {
        mEditor.putInt("addressId",addressId);
        mEditor.commit();
      //  this.addressId = addressId;
    }

    public String getUserName() {
        userName = mSharedPreferences.getString("defaultUserName", "");
        return userName;
    }

    public void setUserName(String defaultUserName) {
        //  this.userName = userName;
        mEditor.putString("defaultUserName", defaultUserName);
        mEditor.commit();
    }

    public int getSex() {
        sex = mSharedPreferences.getInt("defaultSex", 0);
        return sex;
    }

    public void setSex(int defaultSex) {
        //  this.sex = sex;
        mEditor.putInt("defaultSex", defaultSex);
        mEditor.commit();
    }

    public String getLocation() {
        location = mSharedPreferences.getString("defaultLocation", "");
        return location;
    }

    public void setLocation(String defaultLocation) {
        //  this.location = location;
        mEditor.putString("defaultLocation", defaultLocation);
        mEditor.commit();
    }

    public String getAddress() {
        address = mSharedPreferences.getString("defaultAddress", address);
        return address;
    }

    public void setAddress(String defaultAddress) {
        //  this.address = address;
        mEditor.putString("defaultAddress", defaultAddress);
        mEditor.commit();
    }

    public long getPhoneNumber() {
        phoneNumber = mSharedPreferences.getLong("defaultPhoneNumber", 0);
        return phoneNumber;
    }

    public void setPhoneNumber(long defaultPhoneNumber) {
        // this.phoneNumber = phoneNumber;
        mEditor.putLong("defaultPhoneNumber", defaultPhoneNumber);
        mEditor.commit();
    }

    public float getLongitude() {
        longitude = mSharedPreferences.getFloat("defaultLongitude", 0);
        return longitude;
    }

    public void setLongitude(float defaultLongitude) {
        mEditor.putFloat("defaultLongitude", defaultLongitude);
        mEditor.commit();
    }

    public float getLatitude() {
        latitude = mSharedPreferences.getFloat("defaultLatitude", 0);
        return latitude;
    }

    public void setLatitude(float defaultLatitude) {
        mEditor.putFloat("defaultLatitude", defaultLatitude);
        mEditor.commit();
    }

}
