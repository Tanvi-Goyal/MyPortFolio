package com.example.tanvi.myportfolio.DataClasses;

public class WorkExperienceDataClass {

    String certificate , company , description , duration , image , job_title;

    public WorkExperienceDataClass() {
    }

    public WorkExperienceDataClass(String certificate, String company, String description, String duration, String image, String job_title) {
        this.certificate = certificate;
        this.company = company;
        this.description = description;
        this.duration = duration;
        this.image = image;
        this.job_title = job_title;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getJob_title() {
        return job_title;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }
}
