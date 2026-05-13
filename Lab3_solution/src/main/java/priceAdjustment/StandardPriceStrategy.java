package priceAdjustment;

public class StandardPriceStrategy implements IPriceAdjustmentStrategy {
    @Override
    public double calculateAdjustment(double basePrice) {
        return 0.0; // brak zmian
    }
}
