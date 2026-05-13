package restauracione.decorator;

import restauracione.warehouse.Sauce;
import restauracione.warehouse.WarehouseRecord;

import java.util.List;

public class ExtraSauceDishDecorator extends DishDecorator{
    public ExtraSauceDishDecorator(IDishable dish) {
        super(dish);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 3;
    }

    @Override
    public List<WarehouseRecord> getWarehouseRecords() {
        var records = super.getWarehouseRecords();
        records.add(new WarehouseRecord(new Sauce(), 3));
        return records;
    }
}
