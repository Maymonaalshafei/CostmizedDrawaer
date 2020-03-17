package com.example.costmizeddrawaer;

public class ViewPagerModel {

    private String pageName;
    private  Integer counter;
    private int backGroundPhoto;

    public ViewPagerModel(String pageName, Integer counter,int backGroundPhoto) {
        this.pageName = pageName;
        this.counter = counter;
        this.backGroundPhoto = backGroundPhoto;
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public Integer getCounter() {
        return counter;
    }

    public void setCounter(Integer counter) {
        this.counter = counter;
    }

    public int getBackGroundPhoto() {
        return backGroundPhoto;
    }

    public void setBackGroundPhoto(int backGroundPhoto) {
        this.backGroundPhoto = backGroundPhoto;
    }
}
