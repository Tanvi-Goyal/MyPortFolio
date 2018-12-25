package com.example.tanvi.myportfolio.DataClasses;

public class ResponsiblitiesDataClass {

    String certificate , duration , image, institution , title , description;

    public ResponsiblitiesDataClass() {
    }

    public ResponsiblitiesDataClass(String certificate, String duration, String image, String institution, String title , String description) {
        this.certificate = certificate;
        this.duration = duration;
        this.image = image;
        this.institution = institution;
        this.title = title;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getInstitution() {
        return institution;
    }

    public void setInstituition(String institution) {
        this.institution = institution;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
