package reservations;

public interface ISpaceReservation {
    void confirmReservation();
    double getPrice();
    void adjustPrice(double adjustment);
    String getSummary();
}