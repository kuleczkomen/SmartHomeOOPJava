package reservations;

import priceAdjustment.IPriceAdjustmentStrategy;
import priceAdjustment.PriceStrategyFactory;
import trip.SpaceTrip;

public class ReservationPlanner {

    public ISpaceReservation planTrip(SpaceTripType type, SpaceTrip trip) {
        // 1. Wybór fabryki na podstawie Enuma (Simple Factory logic)
        ISpaceReservationFactory factory = switch (type) {
            case COLONIST -> new ColonistSpaceReservationFactory();
            case SCIENCE -> new ScienceSpaceReservationFactory();
        };

        // 2. Stworzenie bazowej rezerwacji (Factory Method)
        ISpaceReservation reservation = factory.createReservation(trip);

        // 3. Dobranie strategii cenowej na podstawie daty (Strategy Factory)
        IPriceAdjustmentStrategy priceStrategy = PriceStrategyFactory.getStrategy(trip.getLaunchDate());

        // 4. Zaaplikowanie strategii i finalizacja
        double adjustment = priceStrategy.calculateAdjustment(reservation.getPrice());
        reservation.adjustPrice(adjustment);

        System.out.println("Zastosowano strategię: " + priceStrategy.getClass().getSimpleName());
        return reservation;
    }
}
