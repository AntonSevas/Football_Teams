package com.twobro.footballteams.model;

public class Clubs {

    int id;
    String img, clubName, country, trainer, color;

    public Clubs(int id, String img, String clubName, String country, String trainer, String color) {
        this.id = id;
        this.img = img;
        this.clubName = clubName;
        this.country = country;
        this.trainer = trainer;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTrainer() {
        return trainer;
    }

    public void setTrainer(String trainer) {
        this.trainer = trainer;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
