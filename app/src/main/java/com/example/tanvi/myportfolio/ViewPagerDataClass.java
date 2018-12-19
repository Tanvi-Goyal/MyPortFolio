package com.example.tanvi.myportfolio;

public class ViewPagerDataClass {

    String image , title , text ;

    public ViewPagerDataClass(String image, String title, String text) {
        this.image = image;
        this.title = title;
        this.text = text;
    }

    public ViewPagerDataClass() {
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
