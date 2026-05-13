package restauracione.command;

import restauracione.DailyRegistry;
import restauracione.decorator.IDishable;
import restauracione.food.Order;
import restauracione.warehouse.Warehouse;
import restauracione.warehouse.WarehouseRecord;

import java.util.List;

public class PutOrderCommand implements ICommand{
    private List<IDishable> dishes;
    private DailyRegistry dailyRegistry;

    public PutOrderCommand(List<IDishable> dishes, DailyRegistry dailyRegistry) {
        this.dishes = dishes;
        this.dailyRegistry = dailyRegistry;
    }

    @Override
    public boolean tryExecute() {
        //potencjalnie to Id byłoby generowane z jakieś sekwencji, ale nie chcemy sie w to tu bawic
        var order = new Order(1, dishes);

        var productsUsed = dishes.stream()
                .flatMap(x -> x.getWarehouseRecords().stream())
                .toList();
        var productRemovalResult = Warehouse.TryRemoveProducts(productsUsed);

        if (productRemovalResult == false){
            return false;
        }

        dailyRegistry.addOrder(order);
        return true;
    }

    @Override
    public void undo() {

    }
}
