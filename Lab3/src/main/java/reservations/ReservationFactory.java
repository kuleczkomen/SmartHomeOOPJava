package reservations;

import trip.SpaceTrip;

public abstract class ReservationFactory {

    public void generalLogic() {

    }

    public abstract SpaceReservation createReservation(SpaceTrip spaceTrip);
}
