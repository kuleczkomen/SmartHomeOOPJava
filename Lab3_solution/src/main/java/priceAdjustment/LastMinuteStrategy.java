package priceAdjustment;

public class LastMinuteStrategy implements IPriceAdjustmentStrategy {
    @Override
    public double calculateAdjustment(double basePrice) {
        return basePrice * 0.70; // +70% kary za pośpiech
    }
}
