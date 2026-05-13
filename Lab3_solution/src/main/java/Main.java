import reservations.ReservationPlanner;
import reservations.ISpaceReservation;
import reservations.SpaceTripType;
import trip.SpaceTrip;
import trip.SpaceTripBuilder;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        // Teraz możemy używać samych nazw klas:
        ReservationPlanner planner = new ReservationPlanner();

        System.out.println("=== SYSTEM REZERWACJI MIĘDZYPLANETARNYCH: START ===\n");

        runColonistStandardFlow(planner);
        runScienceDeepSpaceFlow(planner);
        runLastMinuteEmergencyFlow(planner);

        System.out.println("\n=== WSZYSTKIE OPERACJE ZAKOŃCZONE ===");
    }

    private static void runColonistStandardFlow(ReservationPlanner planner) {
        System.out.println("--- Scenariusz 1: Standardowa Kolonizacja Marsa ---");

        SpaceTrip marsTrip = new SpaceTripBuilder("Mars", LocalDate.now().plusMonths(8))
                .forDuration(365)
                .withOxygenTanks(10)
                .build();

        ISpaceReservation res = planner.planTrip(SpaceTripType.COLONIST, marsTrip);
        printReservationDetails(res);
    }

    private static void runScienceDeepSpaceFlow(ReservationPlanner planner) {
        System.out.println("\n--- Scenariusz 2: Misja Badawcza DeepSpace (High Risk) ---");

        SpaceTrip deepSpaceTrip = new SpaceTripBuilder("DeepSpace", LocalDate.now().plusMonths(3))
                .withInsurance(2000000.0)
                .forDuration(120)
                .build();

        ISpaceReservation res = planner.planTrip(SpaceTripType.SCIENCE, deepSpaceTrip);
        printReservationDetails(res);
    }

    private static void runLastMinuteEmergencyFlow(ReservationPlanner planner) {
        System.out.println("\n--- Scenariusz 3: Awaryjny lot Last Minute ---");

        SpaceTrip emergencyTrip = new SpaceTripBuilder("Księżyc", LocalDate.now().plusDays(5))
                .build();

        try {
            ISpaceReservation res = planner.planTrip(SpaceTripType.COLONIST, emergencyTrip);
            printReservationDetails(res);
        } catch (Exception e) {
            System.err.println("BŁĄD SYSTEMU: " + e.getMessage());
        }
    }

    private static void printReservationDetails(ISpaceReservation res) {
        System.out.println(res.getSummary());
        System.out.println("Cena bazowa: " + res.getPrice() + " cr");
    }
}