package restauracione.warehouse;

import restauracione.food.Ingredient;

import java.util.*;

public class Warehouse {
    private static final List<WarehouseRecord> ingredientStock = new ArrayList<>() {};

    static {
        ingredientStock.add(new WarehouseRecord(Ingredient.FLOUR, 50));
        ingredientStock.add(new WarehouseRecord(Ingredient.CHEESE, 30));
        ingredientStock.add(new WarehouseRecord(Ingredient.TOMATO_SAUCE, 40));
        ingredientStock.add(new WarehouseRecord(Ingredient.MUSHROOMS, 25));
        ingredientStock.add(new WarehouseRecord(Ingredient.ONION, 35));
        ingredientStock.add(new WarehouseRecord(Ingredient.SALAMI, 20));
        ingredientStock.add(new WarehouseRecord(Ingredient.OLIVES, 15));
        ingredientStock.add(new WarehouseRecord(new Sauce(), 50));
        ingredientStock.add(new WarehouseRecord(new Container(), 100));
    }

    //najpierw check czy mozna na wszystkich składnikach dokonać zmiany - bo jak wiecie z baz danych transakcyjność jest ważna
    //a w rollbackowanie nam się nie chce bawić
    //dopiero jak mamy pewność że wszystkie składniki są dostępne w odpowiedniej ilości to dokonujemy zmiany
    public static boolean TryRemoveProducts(List<WarehouseRecord> products){
        for (WarehouseRecord product : products) {
            Optional<WarehouseRecord> record = ingredientStock.stream()
                    .filter(r -> r.product().productEquals(product.product()))
                    .findFirst();

            if (record.isEmpty() || record.get().quantity() < product.quantity()) {
                return false;
            }
        }

        for (WarehouseRecord product : products) {
            WarehouseRecord record = ingredientStock.stream()
                    .filter(r -> r.product().productEquals(product.product()))
                    .findFirst()
                    .orElseThrow(() -> new IllegalStateException("Produkt " + product.product() + " nie jest dostępny w magazynie w momencie odejmowania."));

            int newQuantity = record.quantity() - product.quantity();
            ingredientStock.remove(record);
            ingredientStock.add(new WarehouseRecord(record.product(), newQuantity));
        }

        return true;
    }

    public static void addProducts(List<WarehouseRecord> products) {
        for (WarehouseRecord product : products) {
            AddProduct(product);
        }
    }

    public static void reset() {
        ingredientStock.clear();
        ingredientStock.add(new WarehouseRecord(Ingredient.FLOUR, 50));
        ingredientStock.add(new WarehouseRecord(Ingredient.CHEESE, 30));
        ingredientStock.add(new WarehouseRecord(Ingredient.TOMATO_SAUCE, 40));
        ingredientStock.add(new WarehouseRecord(Ingredient.MUSHROOMS, 25));
        ingredientStock.add(new WarehouseRecord(Ingredient.ONION, 35));
        ingredientStock.add(new WarehouseRecord(Ingredient.SALAMI, 20));
        ingredientStock.add(new WarehouseRecord(Ingredient.OLIVES, 15));
        ingredientStock.add(new WarehouseRecord(new Sauce(), 50));
        ingredientStock.add(new WarehouseRecord(new Container(), 100));
    }

    private static void AddProduct(WarehouseRecord recordToAdd) {
        Optional<WarehouseRecord> recordFromWarehouse = ingredientStock.stream()
                .filter(r -> r.product().productEquals(recordToAdd.product()))
                .findFirst();

        if (recordFromWarehouse.isPresent()) {
            var existingRecord = recordFromWarehouse.get();
            int newQuantity = existingRecord.quantity() + recordToAdd.quantity();
            ingredientStock.remove(existingRecord);
            ingredientStock.add(new WarehouseRecord(existingRecord.product(), newQuantity));
        } else {
            ingredientStock.add(recordToAdd);
        }
    }
}
