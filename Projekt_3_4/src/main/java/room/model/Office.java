package room.model;

import device.LedLamp;
import device.Speaker;
import device.thermostat.Thermostat;

public class Office extends ARoom{

    public Office(LedLamp ledLamp, Speaker speaker, Thermostat thermostat) {
        this.ledLamp = ledLamp;
        this.speaker = speaker;
        this.thermostat = thermostat;
    }

}
