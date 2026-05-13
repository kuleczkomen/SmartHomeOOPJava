package reservations;

import trip.SpaceTrip;

public class ColonistSpaceReservation implements ISpaceReservation {
    private final SpaceTrip trip;
    private final double subsidy;
    private double price;
    public ColonistSpaceReservation(SpaceTrip trip, double subsidy) {
        this.trip = trip;
        this.subsidy = subsidy;
        this.price = (trip.getDurationDays() * 1000.0) - subsidy;
    }

    @Override
    public void confirmReservation() {
        System.out.println("Zatwierdzono przydział kolonizacyjny na: " + trip.getDestination());
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public void adjustPrice(double adjustment) {
        this.price += adjustment;
    }

    @Override
    public String getSummary() {
        return "Typ: KOLONISTA, Cel: " + trip.getDestination() + ", Kwota: " + getPrice();
    }
}