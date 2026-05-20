package room.model;

import device.LedLamp;
import device.speaker.Speaker;
import device.thermostat.Thermostat;

public abstract class ARoom implements IRoom {

    protected LedLamp ledLamp;
    protected Speaker speaker;
    protected Thermostat thermostat;

    @Override
    public void setLedLamp(LedLamp ledLamp) {
        this.ledLamp = ledLamp;
    }

    @Override
    public void setSpeaker(Speaker speaker) {
        this.speaker = speaker;
    }

    @Override
    public void setThermostat(Thermostat thermostat) {
        this.thermostat = thermostat;
    }

    @Override
    public LedLamp getLedLamp() {
        return ledLamp;
    }

    @Override
    public Speaker getSpeaker() {
        return speaker;
    }

    @Override
    public Thermostat getThermostat() {
        return thermostat;
    }


}
