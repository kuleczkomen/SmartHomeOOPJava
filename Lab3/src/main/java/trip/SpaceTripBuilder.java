package trip;

import java.time.LocalDate;

public class SpaceTripBuilder {

    private  String destination;
    private  Double insuranceLimit = null;
    private  LocalDate launchDate;
    private  Integer extraOxygenTanks = null;
    private  int durationDays;
    private  String shipModuleType = "STANDARD_V2";

    public SpaceTripBuilder withDestination(String destination) {
        this.destination = destination;
        return this;
    }

    public SpaceTripBuilder withInsuranceLimit(Double insuranceLimit) {
        this.insuranceLimit = insuranceLimit;
        return this;
    }

    public SpaceTripBuilder withLaunchDate(LocalDate launchDate) {
        this.launchDate = launchDate;
        return this;
    }

    public SpaceTripBuilder withExtraOxygenTanks(Integer extraOxygenTanks) {
        this.extraOxygenTanks = extraOxygenTanks;
        return this;
    }

    public SpaceTripBuilder withDurationDays(int durationDays) {
        this.durationDays = durationDays;
        return this;
    }

    public SpaceTripBuilder withShipModuleType(String shipModuleType) {
        this.shipModuleType = shipModuleType;
        return this;
    }

    public SpaceTrip build() {
        return new SpaceTrip(
                destination,
                insuranceLimit,
                launchDate,
                extraOxygenTanks,
                durationDays,
                shipModuleType
        );
    }
}
