package com.hl.htk_customer.entity;

import java.io.Serializable;
import java.util.List;

public class ShopDeliveryFeeEntity {
    private int code;
    private String message;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean implements Serializable {
        private Integer id;
        public Integer getId() {
            return id;
        }
        public void setId(Integer id) {
            this.id = id;
        }
        public Double getMinRadii() {
            return minRadii;
        }
        public void setMinRadii(Double minRadii) {
            this.minRadii = minRadii;
        }
        public Double getMaxRadii() {
            return maxRadii;
        }
        public void setMaxRadii(Double maxRadii) {
            this.maxRadii = maxRadii;
        }
        public Double getDeliveryFee() {
            return deliveryFee;
        }
        public void setDeliveryFee(Double deliveryFee) {
            this.deliveryFee = deliveryFee;
        }
        public Integer getShopId() {
            return shopId;
        }
        public void setShopId(Integer shopId) {
            this.shopId = shopId;
        }
        private Double minRadii;
        private Double maxRadii;
        private Double deliveryFee;
        private Integer shopId;
    }
}
