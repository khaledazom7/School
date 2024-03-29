package com.amjad.school.model;

public class Category {
    private int id;
    private int image;
    private String title;
    private String subTitle;

    public Category(int id, int image, String title, String subTitle) {
        this.id = id;
        this.image = image;
        this.title = title;
        this.subTitle = subTitle;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public String getSubTitle() {

        return subTitle;
    }

    public void setSubTitle(String subTitle) {

        this.subTitle = subTitle;
    }
}
