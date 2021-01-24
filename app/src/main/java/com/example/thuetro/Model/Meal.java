package com.example.thuetro.Model;

public class Meal {
    private String image;
    private String title;
    private String content;
    private String ingredients;

    public Meal() {
    }

    public Meal(String image, String title, String content, String ingredients) {
        this.image = image;
        this.title = title;
        this.content = content;
        this.ingredients = ingredients;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        return (getTitle());
    }
}
