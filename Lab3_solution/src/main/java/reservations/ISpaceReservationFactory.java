package reservations;

import trip.SpaceTrip;

public interface ISpaceReservationFactory {
    ISpaceReservation createReservation(SpaceTrip trip);
}