package com.example.tanvi.myportfolio.DataClasses;

public class ProjectsDataClass {

    String description , duration , image , institution , link , title ;

    public ProjectsDataClass() {
    }

    public ProjectsDataClass(String description, String duration, String image, String institution, String link, String title) {
        this.description = description;
        this.duration = duration;
        this.image = image;
        this.institution = institution;
        this.link = link;
        this.title = title;
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

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
