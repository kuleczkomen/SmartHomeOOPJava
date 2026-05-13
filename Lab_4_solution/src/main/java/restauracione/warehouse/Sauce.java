package restauracione.warehouse;

public class Sauce implements IProduct{
    @Override
    public boolean productEquals(IProduct product) {
        return this.getClass().equals(product.getClass());
    }
}
