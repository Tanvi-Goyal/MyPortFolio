package com.example.tanvi.myportfolio.DataClasses;

public class TrainingsDataClass {

    String certificate , company , duration , image , title ;

    public TrainingsDataClass() {
    }

    public TrainingsDataClass(String certificate, String company, String duration, String image, String title) {
        this.certificate = certificate;
        this.company = company;
        this.duration = duration;
        this.image = image;
        this.title = title;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
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

}
