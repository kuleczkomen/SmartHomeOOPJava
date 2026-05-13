package room;

import device.IDevice;
import device.LedLamp;
import device.Speaker;
import device.Thermostat;

import java.util.List;

public class Kitchen implements IRoom{

    private LedLamp lamp;
    private Speaker speaker;
    private Thermostat thermostat;


    @Override
    public void setLedLamp(LedLamp ledLamp) {
        this.lamp = ledLamp;
    }

    @Override
    public void setSpeaker(Speaker speaker) {
        this.speaker = speaker;
    }

    @Override
    public void setThermostat(Thermostat thermostat) {
        this.thermostat = thermostat;
    }
}
