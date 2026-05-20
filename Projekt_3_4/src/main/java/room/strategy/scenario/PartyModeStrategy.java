package room.strategy.scenario;

import place.House;
import room.model.LivingRoom;

import java.util.List;

public class PartyModeStrategy extends AScenarioStrategy {

    public PartyModeStrategy(String name, String email, int startHour, List<Integer> scenarioDays) {
        super(name, email, startHour, scenarioDays);
    }

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
