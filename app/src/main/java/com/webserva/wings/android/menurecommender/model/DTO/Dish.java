package com.webserva.wings.android.menurecommender.model.DTO;

import java.util.ArrayList;
import java.util.List;

public class Dish {
    private int dish_id;
    private String name;
    private String genre;
    private List<String> ingredients;
    private List<String> ingTypes;
    static int weight;
    static int fat;
    static int salty;
    static int spicy;
    static int sweet;
    static int difficulty;
    private int[] params;

    public int getDish_id() {
        return dish_id;
    }

    public void setDish_id(int dish_id) {
        this.dish_id = dish_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<String> ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getIngTypes() {
        return ingTypes;
    }

    public void setIngTypes(ArrayList<String> ingTypes) {
        this.ingTypes = ingTypes;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        Dish.weight = weight;
    }

    public int getFat() {
        return fat;
    }

    public void setFat(int fat) {
        Dish.fat = fat;
    }

    public int getSalty() {
        return salty;
    }

    public void setSalty(int salty) {
        Dish.salty = salty;
    }

    public int getSpicy() {
        return spicy;
    }

    public void setSpicy(int spicy) {
        Dish.spicy = spicy;
    }

    public int getSweet() {
        return sweet;
    }

    public void setSweet(int sweet) {
        Dish.sweet = sweet;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        Dish.difficulty = difficulty;
    }
}
