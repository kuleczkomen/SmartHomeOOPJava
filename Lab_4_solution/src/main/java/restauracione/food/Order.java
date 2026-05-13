package restauracione.food;

import restauracione.decorator.IDishable;

import java.util.List;

public class Order implements IPriceable {
    private int orderId;
    private boolean isPlaced = false;
    private List<IDishable> dishes;

    public Order(int id, List<IDishable> dishes) {
        this.orderId = id;
        this.dishes = dishes;
    }

    public void addDish(IDishable dish) {
        dishes.add(dish);
    }

    public List<IDishable> getDishes() {
        return dishes;
    }

    public void place() {
        isPlaced = true;
        System.out.println("Zamówienie #" + orderId + " przesłane do kuchni.");
    }

    public void cancel() {
        isPlaced = false;
        System.out.println("Zamówienie #" + orderId + " zostało anulowane.");
    }

    @Override
    public String toString() {
        return "Zamówienie #" + orderId + " (" + dishes.size() + " dań)";
    }

    @Override
    public double getPrice() {
        return dishes.stream()
                .mapToDouble(IDishable::getPrice)
                .sum();
    }
}