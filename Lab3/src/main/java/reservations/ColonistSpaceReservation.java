package reservations;

import trip.SpaceTrip;

public class ColonistSpaceReservation extends ReservationFactory  implements SpaceReservation{
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

    @Override
    public SpaceReservation createReservation(SpaceTrip trip) {
        var baseSubsidy = 2000.00;
        boolean isHighRisk = trip.getInsuranceLimit() != null && trip.getInsuranceLimit() > 1_000_000;
        boolean isGrantApproved = !isHighRisk && trip.getDurationDays() > 30;

        SpaceReservation reservation = new ScienceSpaceReservation(trip, isGrantApproved);

        if(trip.getDestination().equals("DeepSpace")) {
            System.out.println("---LOG---");
        }

        reservation.adjustPrice(getAdjustment(trip.getDurationDays(), reservation.getPrice()));

        return reservation;
    }

    private double getAdjustment(int days, double price) {
        if(days < 30)
            return price * 0.7;
        else if(days <= 90)
            return 0.0;
        else
            return price * -0.3;
    }
}