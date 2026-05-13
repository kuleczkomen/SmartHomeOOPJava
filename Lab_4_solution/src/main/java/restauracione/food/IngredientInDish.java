package restauracione.food;

public class IngredientInDish implements IPriceable{
    private Ingredient ingredient;
    private int weightInUnits;

    public IngredientInDish(Ingredient ingredient, int weightInUnits) {
        this.ingredient = ingredient;
        this.weightInUnits = weightInUnits;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public int getWeight() {
        return weightInUnits;
    }

    @Override
    public double getPrice() {
        return ingredient.getPricePerUnit() * weightInUnits;
    }
}