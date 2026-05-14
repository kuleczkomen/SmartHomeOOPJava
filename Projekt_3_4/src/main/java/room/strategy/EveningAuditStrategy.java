package room.strategy;

import place.House;

public class EveningAuditStrategy extends AScenarioStrategy {
    @Override
    public void useScenario(House house) {
        house.switchOffAllSpeakers();
        house.getGroundFloor().switchOffAllLights();
        house.getFirstFloor().getBedroom().getThermostat().setTemp(17);
        sendReport();
    }
}
