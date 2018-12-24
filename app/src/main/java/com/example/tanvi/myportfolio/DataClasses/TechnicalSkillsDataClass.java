package com.example.tanvi.myportfolio.DataClasses;

public class TechnicalSkillsDataClass {

    String skill , rate ;

    public TechnicalSkillsDataClass() {
    }

    public TechnicalSkillsDataClass(String skill, String rate) {
        this.skill = skill;
        this.rate = rate;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }
}
