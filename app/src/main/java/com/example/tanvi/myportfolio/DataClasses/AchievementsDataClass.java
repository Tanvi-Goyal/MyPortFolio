package com.example.tanvi.myportfolio.DataClasses;

public class AchievementsDataClass {

    String certificate , description , position , time , title;

    public AchievementsDataClass() {
    }

    public AchievementsDataClass(String certificate, String description, String position, String time, String title) {
        this.certificate = certificate;
        this.description = description;
        this.position = position;
        this.time = time;
        this.title = title;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
