package Controller;

import java.util.List;

public class DishController {

    private Model.DishModel dishModel;

    public DishController() {
        dishModel = new Model.DishModel();
        dishModel.loadDishes();
    }

    public void addDish(Model.DishModel dish) {
        dishModel.addDish(dish);
    }

    public void updateDish(int index, Model.DishModel dish) {
        dishModel.updateDish(index, dish);
    }

    public Model.Dish getDish(int index){
        return dishModel.getDish(index);
    }

    public void deleteDish(int index) {
        dishModel.deleteDish(index);
    }

    public List<Model.Dish> getDishes() {
        return dishModel.getDishes();
    }
    

}
