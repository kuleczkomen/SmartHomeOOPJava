package trip;

import org.jetbrains.annotations.Nullable;
import java.time.LocalDate;

public class SpaceTrip {
    private final String destination;
    private final Double insuranceLimit;
    private final LocalDate launchDate;
    private final Integer extraOxygenTanks;
    private final int durationDays;
    private final String shipModuleType;

    public SpaceTrip(
            String destination,
            @Nullable Double insuranceLimit,
            LocalDate launchDate,
            @Nullable Integer extraOxygenTanks,
            int durationDays,
            String shipModuleType
    ) {
        this.destination = destination;
        this.insuranceLimit = insuranceLimit;
        this.launchDate = launchDate;
        this.extraOxygenTanks = extraOxygenTanks;
        this.durationDays = durationDays;
        this.shipModuleType = shipModuleType;
    }

    public String getDestination() { return destination; }
    public int getDurationDays() { return durationDays; }
    public LocalDate getLaunchDate() { return launchDate; }
    @Nullable public Double getInsuranceLimit() { return insuranceLimit; }
    @Nullable public Integer getExtraOxygenTanks() { return extraOxygenTanks; }
}