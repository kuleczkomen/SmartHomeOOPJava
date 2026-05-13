package trip;

import java.time.LocalDate;

public class SpaceTripBuilder {
    private String destination;
    private Double insuranceLimit = null;
    private LocalDate launchDate;
    private Integer extraOxygenTanks = null;
    private int durationDays = 14;
    private String shipModuleType = "STANDARD_V2";

    public SpaceTripBuilder(String destination, LocalDate launchDate) {
        this.destination = destination;
        this.launchDate = launchDate;
    }

    public SpaceTripBuilder withInsurance(Double limit) {
        this.insuranceLimit = limit;
        return this;
    }

    public SpaceTripBuilder withOxygenTanks(Integer count) {
        this.extraOxygenTanks = count;
        return this;
    }

    public SpaceTripBuilder forDuration(int days) {
        this.durationDays = days;
        return this;
    }

    public SpaceTrip build() {
        return new SpaceTrip(destination, insuranceLimit, launchDate, extraOxygenTanks, durationDays, shipModuleType);
    }
}