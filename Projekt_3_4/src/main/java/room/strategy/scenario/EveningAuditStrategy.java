package room.strategy.scenario;

import place.House;

import java.util.List;

public class EveningAuditStrategy extends AScenarioStrategy {

    public EveningAuditStrategy(String name, String email, int startHour, List<Integer> scenarioDays) {
        super(name, email, startHour, scenarioDays);
    }

    @Override
    protected void useScenario(House house) {
        house.switchOffAllSpeakers();

        house
            .getGroundFloor()
            .switchOffAllLights();

        house
            .getFirstFloor().
            getBedroom()
            .getThermostat()
            .setTemp(17);
    }
}
