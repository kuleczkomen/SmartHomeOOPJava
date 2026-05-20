package room.strategy.scenario;

import place.House;
import room.model.LivingRoom;

public class PartyModeStrategy extends AScenarioStrategy {
    @Override
    protected void useScenario(House house) {
        house
            .getGroundFloor()
            .switchOnEverything();

        LivingRoom livingRoom = house
                .getGroundFloor()
                .getLivingRoom();

        int maxVolInLivingRoom = house.getMaxVolumeIn(livingRoom);
        house.setVolumeIn(livingRoom, maxVolInLivingRoom);

        // wyłączam wszystkie światła, oprócz tych w salonie
        house.switchOffAllLights();
        livingRoom
                .getLedLamp()
                .switchOn();

        livingRoom
                .getThermostat()
                .setTemp(20);
    }
}
