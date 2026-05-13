package priceAdjustment;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class PriceStrategyFactory {
    public static IPriceAdjustmentStrategy getStrategy(LocalDate launchDate) {
        long daysToLaunch = ChronoUnit.DAYS.between(LocalDate.now(), launchDate);

        if (daysToLaunch < 30) {
            return new LastMinuteStrategy();
        } else if (daysToLaunch > 180) {
            return new EarlyBirdStrategy();
        }
        return new StandardPriceStrategy();
    }
}