package restauracione;

import restauracione.food.IPriceable;
import restauracione.food.Order;

import java.util.ArrayList;
import java.util.List;

public class DailyRegistry implements IPriceable {
    private List<Order> completedOrders;

    public DailyRegistry() {
        this.completedOrders = new ArrayList<>();
    }

    public void addOrder(Order order) {
        completedOrders.add(order);
    }

    public List<Order> getCompletedOrders() {
        return new ArrayList<>(completedOrders);
    }

    public int getTotalOrdersCount() {
        return completedOrders.size();
    }

    @Override
    public String toString() {
        return "Rejestr Dzienny: " + completedOrders.size() + " zamówień";
    }

    @Override
    public double getPrice() {
        return completedOrders.stream().map(x -> x.getPrice()).reduce(0.0, Double::sum);
    }
}
