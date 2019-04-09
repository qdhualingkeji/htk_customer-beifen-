package com.hl.htk_customer.model;

/**
 * Created by Administrator on 2017/6/28.
 */

public class ShopInfoModel {

    private  static  String  url = "";
    private static String  shopName = "";
    private static String  mobilePhone = "";

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
}
