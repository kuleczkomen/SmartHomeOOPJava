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
        kitchen.getThermostat().switchOn();
        kitchen.getSpeaker().switchOn();
        kitchen.getLedLamp().switchOn();

        livingRoom.getThermostat().switchOn();
        livingRoom.getSpeaker().switchOn();
        livingRoom.getLedLamp().switchOn();
    }

    @Override
    public void switchOffEverything() {
        kitchen.getThermostat().switchOff();
        kitchen.getSpeaker().switchOff();
        kitchen.getLedLamp().switchOff();

        livingRoom.getThermostat().switchOff();
        livingRoom.getSpeaker().switchOff();
        livingRoom.getLedLamp().switchOff();
    }

    @Override
    public void switchOnAllSpeakers() {
        kitchen.getSpeaker().switchOn();
        livingRoom.getSpeaker().switchOn();
    }

    @Override
    public void switchOnAllLights() {
        kitchen.getLedLamp().switchOn();
        livingRoom.getLedLamp().switchOn();
    }

    @Override
    public void switchOnAllThermostats() {
        kitchen.getThermostat().switchOn();
        livingRoom.getThermostat().switchOn();
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
        livingRoom.getThermostat().switchOff();
    }

    @Override
    public void setTempEverywhere(int temp) {
        kitchen.getThermostat().setTemp(temp);
        livingRoom.getThermostat().setTemp(temp);
    }

    @Override
    public void setVolumeEverywhere(int volume) {
        kitchen.getSpeaker().setVolume(volume);
        livingRoom.getSpeaker().setVolume(volume);
    }

    @Override
    public void setMaxVolumeEverywhrere(int volume) {
        kitchen.getSpeaker().setMaxVolume(volume);
        livingRoom.getSpeaker().setMaxVolume(volume);
    }

    public Kitchen getKitchen() {
        return kitchen;
    }

    public LivingRoom getLivingRoom() {
        return livingRoom;
    }
}
