package com.webserva.wings.android.menurecommender.model.DTO;

import java.util.ArrayList;

public class Dish {
    private int dish_id;
    private String name;
    private String genre;
    private ArrayList<String> ingredients;
    private ArrayList<String> ingTypes;
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

    public ArrayList<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<String> ingredients) {
        this.ingredients = ingredients;
    }

    public ArrayList<String> getIngTypes() {
        return ingTypes;
    }

    public void setIngTypes(ArrayList<String> ingTypes) {
        this.ingTypes = ingTypes;
    }

    public static int getWeight() {
        return weight;
    }

    public static void setWeight(int weight) {
        Dish.weight = weight;
    }

    public static int getFat() {
        return fat;
    }

    public static void setFat(int fat) {
        Dish.fat = fat;
    }

    public static int getSalty() {
        return salty;
    }

    public static void setSalty(int salty) {
        Dish.salty = salty;
    }

    public static int getSpicy() {
        return spicy;
    }

    public static void setSpicy(int spicy) {
        Dish.spicy = spicy;
    }

    public static int getSweet() {
        return sweet;
    }

    public static void setSweet(int sweet) {
        Dish.sweet = sweet;
    }

    public static int getDifficulty() {
        return difficulty;
    }

    public static void setDifficulty(int difficulty) {
        Dish.difficulty = difficulty;
    }
}
