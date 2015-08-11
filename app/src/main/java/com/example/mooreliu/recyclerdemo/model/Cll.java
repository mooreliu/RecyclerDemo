package com.example.mooreliu.recyclerdemo.model;

/**
 * Created by mooreliu on 2015/8/10.
 */
public class Cll {
    private String title;
    private int imgUrl;
    private String content;

    public Cll(String title , int imgUrl,String content) {
        this.title = title;
        this.imgUrl = imgUrl;
        this.content = content;
    }
    public String getTitle() {
        return title;
    }

    public int getImgUrl() {
        return imgUrl;
    }

    public String getContent() {
        return content;
    }

}
