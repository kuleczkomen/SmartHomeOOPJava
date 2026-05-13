package room;

import device.IDevice;
import device.LedLamp;
import device.Speaker;
import device.Thermostat;

import java.util.List;

public interface IRoom {

    void setLedLamp(LedLamp ledLamp);
    void setSpeaker(Speaker speaker);
    void setThermostat(Thermostat thermostat);

}
