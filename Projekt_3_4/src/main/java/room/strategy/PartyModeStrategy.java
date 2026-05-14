package room.strategy;

import place.House;
import room.model.Kitchen;
import room.model.LivingRoom;

public class PartyModeStrategy implements IScenarioStrategy {
    @Override
    public void useScenario(House house) {
        house.getGroundFloor().switchOnEverything();

        // narazie wersja podstawowa
        LivingRoom livingRoom = house.getGroundFloor().getLivingRoom();
        int maxVolInLivingRoom = house.getMaxVolumeIn(livingRoom);
        house.setVolumeIn(livingRoom, maxVolInLivingRoom);
    }
}
