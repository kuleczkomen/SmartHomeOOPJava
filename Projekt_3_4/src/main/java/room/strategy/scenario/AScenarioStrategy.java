package room.strategy.scenario;

import place.House;

import java.util.List;

public abstract class AScenarioStrategy {

    protected String email;
    protected int startHour;
    protected List<Integer> scenarioDays;

    public final void runScenario(House house) {
        useScenario(house);
        sendReport();
    }

    protected abstract void useScenario(House house);

    private void sendReport() {
        if(email != null) {
            IO.println("Na email %s wysysłano raport...".formatted(email));
        }
    }
}
