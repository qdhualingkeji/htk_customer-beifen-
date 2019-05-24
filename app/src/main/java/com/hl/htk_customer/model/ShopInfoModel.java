package com.hl.htk_customer.model;

/**
 * Created by Administrator on 2017/6/28.
 */

public class ShopInfoModel {

    private  static  String  url = "";
    private static String  shopName = "";
    private static String  mobilePhone = "";
    private static double longitude = 0.0;
    private static double latitude = 0.0;
    private static double startDeliveryPrice = 0.0;

    public static double getLongitude() {
        return longitude;
    }

    public static void setLongitude(double longitude) {
        ShopInfoModel.longitude = longitude;
    }

    public static double getLatitude() {
        return latitude;
    }

    public static void setLatitude(double latitude) {
        ShopInfoModel.latitude = latitude;
    }

    public static String getMobilePhone() {
        return mobilePhone;
    }

    public static void setMobilePhone(String mobilePhone) {
        ShopInfoModel.mobilePhone = mobilePhone;
    }

    public static String getUrl() {
        return url;
    }

    public static void setUrl(String url) {
        ShopInfoModel.url = url;
    }

    public static String getShopName() {
        return shopName;
    }

    public static void setShopName(String shopName) {
        ShopInfoModel.shopName = shopName;
    }

    public static double getStartDeliveryPrice() {
        return startDeliveryPrice;
    }

    public static void setStartDeliveryPrice(double startDeliveryPrice) {
        ShopInfoModel.startDeliveryPrice = startDeliveryPrice;
    }
}
