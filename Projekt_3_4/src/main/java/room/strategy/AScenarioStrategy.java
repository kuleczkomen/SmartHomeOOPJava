package room.strategy;

import place.House;

import java.util.List;

public abstract class AScenarioStrategy {

    protected String email;
    protected int startHour;
    protected List<Integer> scenarioDays;

    abstract void useScenario(House house);

    protected void sendReport() {
        IO.println("Na email %s wysysłano raport...".formatted(email));
    }
}
