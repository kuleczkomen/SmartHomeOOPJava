package reservations;

import trip.SpaceTrip;

public class ScienceSpaceReservation implements ISpaceReservation {
    private final SpaceTrip trip;
    private final boolean grantApproved;
    private double price;

    public ScienceSpaceReservation(SpaceTrip trip, boolean grantApproved) {
        this.trip = trip;
        this.grantApproved = grantApproved;
        this.price = grantApproved ? 25000.0 : 50000.0;
    }

    @Override
    public void confirmReservation() {
        System.out.println("Zarezerwowano czas badawczy na orbicie: " + trip.getDestination());
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void adjustPrice(double adjustment) {
        price += adjustment;
    }

    @Override
    public String getSummary() {
        return "Typ: NAUKOWIEC, Grant: " + grantApproved + ", Koszt: " + getPrice();
    }
}