package restauracione.warehouse;

public class Container implements IProduct{
    @Override
    public boolean productEquals(IProduct product) {
        return this.getClass().equals(product.getClass());
    }
}
