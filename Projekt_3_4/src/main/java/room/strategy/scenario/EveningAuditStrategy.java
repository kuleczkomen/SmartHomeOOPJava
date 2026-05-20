package room.strategy.scenario;

import place.House;

public class EveningAuditStrategy extends AScenarioStrategy {
    @Override
    protected void useScenario(House house) {
        house.switchOffAllSpeakers();
        house.getGroundFloor().switchOffAllLights();
        house.getFirstFloor().getBedroom().getThermostat().setTemp(17);
    }
}
