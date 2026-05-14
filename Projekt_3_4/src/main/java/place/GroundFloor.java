package place;

import room.model.Kitchen;
import room.model.LivingRoom;

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

    @Override
    public void switchOffAllSpeakers() {
        kitchen.getSpeaker().switchOff();
        livingRoom.getSpeaker().switchOff();
    }

    @Override
    public void switchOffAllLights() {
        kitchen.getLedLamp().switchOff();
        livingRoom.getLedLamp().switchOff();
    }

    @Override
    public void switchOffAllThermostats() {
        kitchen.getThermostat().switchOff();
        livingRoom.getLedLamp().switchOff();
    }

    public Kitchen getKitchen() {
        return kitchen;
    }

    public LivingRoom getLivingRoom() {
        return livingRoom;
    }
}
