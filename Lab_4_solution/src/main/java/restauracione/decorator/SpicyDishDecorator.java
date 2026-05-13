package restauracione.decorator;

public class SpicyDishDecorator extends DishDecorator{
    public SpicyDishDecorator(IDishable dish) {
        super(dish);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 1.5;
    }
}