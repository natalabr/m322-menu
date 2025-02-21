package Model;

import java.util.ArrayList;
import java.util.List;

public class DishModel {
    List<Dish> dishes;

    public DishModel() {
        dishes = new ArrayList<Dish>();
    }

    public void loadDishes() {
        dishes = getDefaultDishes();
    }

    public void addDish(Dish dish) {
        dishes.add(dish);
    }

    public Dish getDish(int index) {
        var d = dishes.get(index);
        var temp = new Dish(
                d.name,
                d.ingredients,
                d.category,
                d.price,
                d.dietaryRestrictions,
                d.spicinessRating);
        return temp;
    }

    public void updateDish(int index, Dish dish) {
        dishes.set(index, dish);
    }

    public void deleteDish(int index) {
        dishes.remove(index);
    }

    public List<Dish> getDishes() {
        List<Dish> temp = new ArrayList<>();
        for (Dish dish : dishes) {
            temp.add(dish);
        }
        return temp;
    }

    public void loadEmployees() {
        dishes = getDefaultDishes();
    }

    public List<Dish> getDefaultDishes() {

        List<Dish> defaultDishes = new ArrayList<>();

        Dish pizza = new Dish(
                "Pizza Margherita",
                "Tomaten, Mozzarella, Basilikum",
                Category.MAINDISH,
                "9.99",
                DietaryRestrictions.VEGETARIAN,
                1
        );

        Dish sushi = new Dish(
                "Sushi Set",
                "Reis, Lachs, Algen, Sojasauce",
                Category.MAINDISH,
                "14.99",
                DietaryRestrictions.GLUTENFREE,
                2
        );

        Dish brownie = new Dish(
                "Schoko Brownie",
                "Schokolade, Mehl, Zucker",
                Category.DESSERT,
                "4.99",
                DietaryRestrictions.VEGETARIAN,
                0
        );

        Dish bruschetta = new Dish(
                "Bruschetta",
                "Geröstetes Brot, Tomaten, Knoblauch, Basilikum, Olivenöl",
                Category.APPETIZER,
                "5.49",
                DietaryRestrictions.VEGAN,
                0
        );

        List<Dish> menu = List.of(pizza, sushi, brownie, bruschetta);

        defaultDishes.add(pizza);
        defaultDishes.add(sushi);
        defaultDishes.add(brownie);
        defaultDishes.add(bruschetta);

        return getDefaultDishes();
    }
}
