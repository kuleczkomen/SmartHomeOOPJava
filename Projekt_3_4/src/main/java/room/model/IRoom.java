package room.model;

import device.LedLamp;
import device.Speaker;
import device.Thermostat;

public interface IRoom {

    void setLedLamp(LedLamp ledLamp);
    void setSpeaker(Speaker speaker);
    void setThermostat(Thermostat thermostat);

    LedLamp getLedLamp();
    Speaker getSpeaker();
    Thermostat getThermostat();

}
