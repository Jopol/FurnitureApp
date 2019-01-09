package com.example.joel.ikeaapp;
import java.io.Serializable;

public class Furniture implements Serializable {
    private String mUrl;
    private String mTitle;
    private String mPrice;
    private String mInStock;
    private String mMadeIn;


    public Furniture(String mUrl, String mTitle, String mPrice, String mInStock, String mMadeIn) {
        this.mUrl = mUrl;
        this.mTitle = mTitle;
        this.mPrice = mPrice;
        this.mInStock = mInStock;
        this.mMadeIn = mMadeIn;

    }

    public Furniture(String name, String price) {
        this.mTitle = name;
        this.mPrice = price;
    }


    public String getmUrl() {
        return mUrl;
    }

    public void setmUrl(String mUrl) {
        this.mUrl = mUrl;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmPrice() {
        return mPrice;
    }

    public void setmPrice(String mPrice) {
        this.mPrice = mPrice;
    }

    public String getmInStock() {
        return mInStock;
    }

    public void setmInStock(String mInStock) {
        this.mInStock = mInStock;
    }

    public String getmMadeIn() {
        return mMadeIn;
    }

    public void setmMadeIn(String mMadeIn) {
        this.mMadeIn = mMadeIn;
    }

}
