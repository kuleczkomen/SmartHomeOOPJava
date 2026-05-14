package room.strategy;

import place.House;
import room.model.LivingRoom;

public class PartyModeStrategy extends AScenarioStrategy {
    @Override
    public void useScenario(House house) {
        house.getGroundFloor().switchOnEverything();

        // narazie wersja podstawowa
        LivingRoom livingRoom = house.getGroundFloor().getLivingRoom();
        int maxVolInLivingRoom = house.getMaxVolumeIn(livingRoom);
        house.setVolumeIn(livingRoom, maxVolInLivingRoom);

        sendReport();
    }
}
