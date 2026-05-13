package place;

import room.Kitchen;
import room.LivingRoom;

public class GroundFloor implements IPlace {

    private final Kitchen kitchen;
    private final LivingRoom livingRoom;

    public GroundFloor(Kitchen kitchen, LivingRoom livingRoom) {
        this.kitchen = kitchen;
        this.livingRoom = livingRoom;
    }

    @Override
    public void switchOnEverything() {

    }

    @Override
    public void switchOffEverything() {

    }
}
