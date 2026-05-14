package room;

import device.IDevice;
import device.LedLamp;
import device.Speaker;
import device.Thermostat;

import java.util.List;

public class LivingRoom implements IRoom{

    private LedLamp lamp;
    private Speaker speaker;
    private Thermostat thermostat;

    public LivingRoom(LedLamp ledLamp, Speaker speaker, Thermostat thermostat) {
        this.lamp = ledLamp;
        this.speaker = speaker;
        this.thermostat = thermostat;
    }

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
