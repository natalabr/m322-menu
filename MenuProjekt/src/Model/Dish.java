package Model;

public class Dish {

    String name;
    String ingredients;
    Category category;
    String price;
    DietaryRestrictions dietaryRestrictions;
    int spicinessRating;

    public Dish(String name, String ingredients, Category category, String price, DietaryRestrictions dietaryRestrictions, int spicinessRating) {
        this.name = name;
        this.ingredients = ingredients;
        this.category = category;
        this.price = price;
        this.dietaryRestrictions = dietaryRestrictions;
        this.spicinessRating = spicinessRating;
    }

    public String toString() {
        return name + " " + price;
    }
}
