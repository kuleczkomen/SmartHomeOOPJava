package restauracione.decorator;

import restauracione.warehouse.WarehouseRecord;

import java.util.List;

public abstract class DishDecorator implements IDishable {
    protected IDishable dish;

    public DishDecorator(IDishable dish) {
        this.dish = dish;
    }

    @Override
    public double getPrice(){
        return dish.getPrice();
    };

    @Override
    public List<WarehouseRecord> getWarehouseRecords() {
        return dish.getWarehouseRecords();
    }
}
