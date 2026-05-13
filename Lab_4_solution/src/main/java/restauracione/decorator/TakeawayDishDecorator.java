package restauracione.decorator;

import restauracione.warehouse.Container;
import restauracione.warehouse.WarehouseRecord;

import java.util.List;

public class TakeawayDishDecorator extends DishDecorator{
    public TakeawayDishDecorator(IDishable dish) {
        super(dish);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 2;
    }

    @Override
    public List<WarehouseRecord> getWarehouseRecords() {
        var records = super.getWarehouseRecords();
        records.add(new WarehouseRecord(new Container(), 1));
        return records;
    }
}