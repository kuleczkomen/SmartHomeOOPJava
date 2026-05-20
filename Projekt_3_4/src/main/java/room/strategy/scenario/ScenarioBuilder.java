package room.strategy.scenario;

import java.util.List;

public class ScenarioBuilder {

    private final String name;
    private String email;
    private int startHour;
    private final List<Integer> scenarioDays;

    private final ScenarioType type;

    public ScenarioBuilder(ScenarioType type, String name, List<Integer> scenarioDays) {
        this.name = name;
        this.type = type;
        this.scenarioDays = scenarioDays;
    }

    public ScenarioBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public ScenarioBuilder withStartHour(int startHour) {
        this.startHour = startHour;
        return this;
    }

    public AScenarioStrategy build() {
        return switch (type) {
            case PARTY_MODE -> new PartyModeStrategy(name, email, startHour, scenarioDays);
            case EVENING_AUDIT -> new EveningAuditStrategy(name, email, startHour, scenarioDays);
        };
    }
}
