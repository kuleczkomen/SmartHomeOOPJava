package place;

import room.model.Bedroom;
import room.model.Office;


public class FirstFloor implements IPlace {

    private final Bedroom bedroom;
    private final Office office;

    public FirstFloor(Bedroom bedroom, Office office) {
        this.bedroom = bedroom;
        this.office = office;
    }

    @Override
    public void switchOnEverything() {
        bedroom.getThermostat().switchOn();
        bedroom.getSpeaker().switchOn();
        bedroom.getLedLamp().switchOn();

        office.getThermostat().switchOn();
        office.getSpeaker().switchOn();
        office.getLedLamp().switchOn();
    }

    @Override
    public void switchOffEverything() {
        bedroom.getThermostat().switchOff();
        bedroom.getSpeaker().switchOff();
        bedroom.getLedLamp().switchOff();

        office.getThermostat().switchOff();
        office.getSpeaker().switchOff();
        office.getLedLamp().switchOff();
    }

    @Override
    public void switchOnAllSpeakers() {
        bedroom.getSpeaker().switchOn();
        office.getSpeaker().switchOn();
    }

    @Override
    public void switchOnAllLights() {
        bedroom.getLedLamp().switchOn();
        office.getLedLamp().switchOn();
    }

    @Override
    public void switchOnAllThermostats() {
        bedroom.getThermostat().switchOn();
        office.getThermostat().switchOn();
    }

    @Override
    public void switchOffAllSpeakers() {
        bedroom.getSpeaker().switchOff();
        office.getSpeaker().switchOff();
    }

    @Override
    public void switchOffAllLights() {
        bedroom.getLedLamp().switchOff();
        office.getLedLamp().switchOff();
    }

    @Override
    public void switchOffAllThermostats() {
        bedroom.getThermostat().switchOff();
        office.getThermostat().switchOff();
    }

    @Override
    public void setTempEverywhere(int temp) {
        bedroom.getThermostat().setTemp(temp);
        office.getThermostat().setTemp(temp);
    }

    @Override
    public void setVolumeEverywhere(int volume) {
        bedroom.getSpeaker().setVolume(volume);
        office.getSpeaker().setVolume(volume);
    }

    @Override
    public void setMaxVolumeEverywhrere(int volume) {
        bedroom.getSpeaker().setMaxVolume(volume);
        office.getSpeaker().setMaxVolume(volume);
    }

    public Bedroom getBedroom() {
        return bedroom;
    }

    public Office getOffice() {
        return office;
    }
}
