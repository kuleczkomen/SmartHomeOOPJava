package restauracione.decorator;

import restauracione.food.IPriceable;
import restauracione.warehouse.IProduct;
import restauracione.warehouse.WarehouseRecord;

import java.util.List;

public interface IDishable extends IPriceable {
    List<WarehouseRecord> getWarehouseRecords();
}
