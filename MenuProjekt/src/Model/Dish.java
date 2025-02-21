package Model;


public class Dish {

    private String name;
    private String ingredients;
    private Category category;
    private String price;
    private DietaryRestrictions dietaryRestrictions;
    private int spicinessRating;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public DietaryRestrictions getDietaryRestrictions() {
        return dietaryRestrictions;
    }

    public void setDietaryRestrictions(DietaryRestrictions dietaryRestrictions) {
        this.dietaryRestrictions = dietaryRestrictions;
    }

    public int getSpicinessRating() {
        return spicinessRating;
    }

    public void setSpicinessRating(int spicinessRating) {
        this.spicinessRating = spicinessRating;
    }
}
