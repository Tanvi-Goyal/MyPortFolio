package com.example.tanvi.myportfolio.DataClasses;

public class ResponsiblitiesDataClass {

    String certificate , duration , image, instituition , title;

    public ResponsiblitiesDataClass() {
    }

    public ResponsiblitiesDataClass(String certificate, String duration, String image, String instituition, String title) {
        this.certificate = certificate;
        this.duration = duration;
        this.image = image;
        this.instituition = instituition;
        this.title = title;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
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

    public String getInstituition() {
        return instituition;
    }

    public void setInstituition(String instituition) {
        this.instituition = instituition;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
