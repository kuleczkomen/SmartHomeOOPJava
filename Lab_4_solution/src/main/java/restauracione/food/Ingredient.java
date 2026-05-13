package restauracione.food;

import restauracione.warehouse.IProduct;

public class Ingredient implements IProduct {
    private IngredientType type;
    private double pricePerUnit;

    // Statyczne składniki z cenami za jednostkę
    public static final Ingredient FLOUR = new Ingredient(IngredientType.FLOUR, 2.50);
    public static final Ingredient CHEESE = new Ingredient(IngredientType.CHEESE, 8.00);
    public static final Ingredient TOMATO_SAUCE = new Ingredient(IngredientType.TOMATO_SAUCE, 3.50);
    public static final Ingredient MUSHROOMS = new Ingredient(IngredientType.MUSHROOMS, 5.00);
    public static final Ingredient ONION = new Ingredient(IngredientType.ONION, 2.00);
    public static final Ingredient SALAMI = new Ingredient(IngredientType.SALAMI, 12.00);
    public static final Ingredient OLIVES = new Ingredient(IngredientType.OLIVES, 6.50);

    private Ingredient(IngredientType type, double pricePerUnit) {
        this.type = type;
        this.pricePerUnit = pricePerUnit;
    }

    public IngredientType getType() {
        return type;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    @Override
    public boolean productEquals(IProduct product) {
        if (!this.getClass().equals(product.getClass())){
            return false;
        }

        Ingredient other = (Ingredient) product;
        return this.type == other.type;
    }
}
