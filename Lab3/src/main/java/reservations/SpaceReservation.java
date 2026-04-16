package reservations;

public interface SpaceReservation {

    void confirmReservation();
    double getPrice();
    void adjustPrice(double adjustment);
    String getSummary();
}
