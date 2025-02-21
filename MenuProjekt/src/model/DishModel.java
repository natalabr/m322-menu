package model;

import java.util.ArrayList;
import java.util.List;

public class DishModel {
    List<Dish> dishes;

    public DishModel() {
        dishes = new ArrayList<Dish>();
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
