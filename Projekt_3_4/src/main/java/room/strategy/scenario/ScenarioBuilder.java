package room.strategy.scenario;

import java.util.List;

public class ScenarioBuilder {

    private final String name;
    private final String email;
    private int startHour;
    private List<Integer> scenarioDays;

    public ScenarioBuilder(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public ScenarioBuilder withStartHour(int startHour) {
        this.startHour = startHour;
        return this;
    }

    public ScenarioBuilder withScenarioDays(List<Integer> scenarioDays) {
        this.scenarioDays = scenarioDays;
    }

    public AScenarioStrategy build() {
        return
    }
}
