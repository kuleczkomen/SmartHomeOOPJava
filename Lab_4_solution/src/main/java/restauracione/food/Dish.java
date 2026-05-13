package restauracione.food;

import restauracione.decorator.IDishable;
import restauracione.warehouse.IProduct;
import restauracione.warehouse.WarehouseRecord;

import java.util.ArrayList;
import java.util.List;

public class Dish implements IDishable {
    private String name;
    private List<IngredientInDish> ingredients;

    public Dish(String name) {
        this.name = name;
        this.ingredients = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addIngredient(IngredientInDish ingredientInDish) {
        ingredients.add(ingredientInDish);
    }

    public List<IngredientInDish> getIngredients() {
        return new ArrayList<>(ingredients);
    }

    public double getPrice() {
        return ingredients.stream()
                .mapToDouble(IngredientInDish::getPrice)
                .sum();
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public List<WarehouseRecord> getWarehouseRecords() {
        return ingredients.stream().map(x -> new WarehouseRecord(x.getIngredient(), x.getWeight())).toList();
    }
}
