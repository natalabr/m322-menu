package model;

public class Dish {

    String dishname;
    String ingredients;
    Category category;
    String price;
    DietaryRestrictions dietaryRestrictions;
    int spicinessRating;

    public Dish(String dishname, String ingredients, Category category, String price, DietaryRestrictions dietaryRestrictions, int spicinessRating) {
        this.dishname = dishname;
        this.ingredients = ingredients;
        this.category = category;
        this.price = price;
        this.dietaryRestrictions = dietaryRestrictions;
        this.spicinessRating = spicinessRating;
    }


}
