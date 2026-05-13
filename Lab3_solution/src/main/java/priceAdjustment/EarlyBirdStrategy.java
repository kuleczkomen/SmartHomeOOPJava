package priceAdjustment;

public class EarlyBirdStrategy implements IPriceAdjustmentStrategy {
    @Override
    public double calculateAdjustment(double basePrice) {
        return -(basePrice * 0.20); // -20% zniżki za planowanie
    }
}