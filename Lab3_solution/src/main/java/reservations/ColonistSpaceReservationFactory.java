package reservations;

import trip.SpaceTrip;

public class ColonistSpaceReservationFactory implements ISpaceReservationFactory {
    @Override
    public ISpaceReservation createReservation(SpaceTrip trip) {
        double baseSubsidy = 5000.0;

        if (trip.getDestination().equalsIgnoreCase("Mars")) {
            baseSubsidy += 10000.0;
        }

        if (trip.getExtraOxygenTanks() != null && trip.getExtraOxygenTanks() > 5) {
            baseSubsidy -= 2000.0;
        }

        return new ColonistSpaceReservation(trip, baseSubsidy);
    }
}