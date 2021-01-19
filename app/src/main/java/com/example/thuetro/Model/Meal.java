package com.example.thuetro.Model;

public class Meal {
    private String image;
    private int igd_num;
    private String title;
    private String content;

    public Meal() {
    }

    public Meal(String image, int igd_num, String title, String content) {
        this.image = image;
        this.igd_num = igd_num;
        this.title = title;
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getIgd_num() {
        return igd_num;
    }

    public void setIgd_num(int igd_num) {
        this.igd_num = igd_num;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return (getTitle());
    }
}
