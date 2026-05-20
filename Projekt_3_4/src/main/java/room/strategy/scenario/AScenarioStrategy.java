package room.strategy.scenario;

import place.House;

import java.util.List;

public abstract class AScenarioStrategy implements IScenarioStrategy{

    protected String name;
    protected String email;
    protected int startHour;
    protected List<Integer> scenarioDays;

    public AScenarioStrategy(String name, String email, int startHour, List<Integer> scenarioDays) {
        this.name = name;
        this.email = email;
        this.startHour = startHour;
        this.scenarioDays = scenarioDays;
    }

    @Override
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
