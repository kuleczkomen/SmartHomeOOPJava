package reservations;

import trip.SpaceTrip;

public class ScienceSpaceReservationFactory implements ISpaceReservationFactory {
    @Override
    public ISpaceReservation createReservation(SpaceTrip trip) {
        boolean isHighRisk = trip.getInsuranceLimit() != null && trip.getInsuranceLimit() > 1000000.0;

        boolean grant = !isHighRisk && trip.getDurationDays() > 30;

        if (trip.getDestination().equals("DeepSpace")) {
            System.out.println("Uwaga: Wykryto misję dalekiego zasięgu. Wymagana zgoda rady.");
        }

        return new ScienceSpaceReservation(trip, grant);
    }
}