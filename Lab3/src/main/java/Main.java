import java.time.LocalDate;

import reservations.ColonistSpaceReservation;
import reservations.ReservationPlanner;
import reservations.ScienceSpaceReservation;
import reservations.SpaceTripType;
import trip.SpaceTrip;

public class Main {

    public static void main(String[] args) {
        ReservationPlanner planner = new ReservationPlanner();

        System.out.println("=== SYSTEM REZERWACJI MIĘDZYPLANETARNYCH: START ===\n");

        runColonistStandardFlow(planner);
        runScienceDeepSpaceFlow(planner);
        runLastMinuteEmergencyFlow(planner);

        System.out.println("\n=== WSZYSTKIE OPERACJE ZAKOŃCZONE ===");
    }

    private static void runColonistStandardFlow(ReservationPlanner planner) {
        System.out.println("--- Scenariusz 1: Standardowa Kolonizacja Marsa ---");

        SpaceTrip marsTrip = SpaceTrip.builder()
                .withDestination("Mars")
                .withLaunchDate(LocalDate.now().plusMonths(8))
                .withExtraOxygenTanks(10)
                .withDurationDays(365)
                .withShipModuleType("COLONIAL_V1")
                .build();

        var res = planner.planColonistTrip(SpaceTripType.COLONIST, marsTrip);
        printReservationDetails(res);
    }

    private static void runScienceDeepSpaceFlow(ReservationPlanner planner) {
        System.out.println("\n--- Scenariusz 2: Misja Badawcza DeepSpace (High Risk) ---");

        SpaceTrip deepSpaceTrip = new SpaceTrip(
                "DeepSpace",
                2000000.0,
                LocalDate.now().plusMonths(3),
                null,
                120,
                "LAB_MODULE"
        );

        var res = planner.planScienceTrip(SpaceTripType.SCIENCE, deepSpaceTrip);
        printReservationDetails(res);
    }

    private static void runLastMinuteEmergencyFlow(ReservationPlanner planner) {
        System.out.println("\n--- Scenariusz 3: Awaryjny lot Last Minute ---");

        SpaceTrip emergencyTrip = new SpaceTrip(
                "Księżyc",
                null,
                LocalDate.now().plusDays(5),
                null,
                14,
                null
        );

        var res = planner.planColonistTrip(SpaceTripType.COLONIST, emergencyTrip);
        printReservationDetails(res);
    }

    private static void printReservationDetails(ColonistSpaceReservation res) {
        System.out.println(res.getSummary());
        System.out.println("Cena końcowa: " + res.getPrice() + " cr");
    }

    private static void printReservationDetails(ScienceSpaceReservation res) {
        System.out.println(res.getSummary());
        System.out.println("Cena końcowa: " + res.getPrice() + " cr");
    }
}