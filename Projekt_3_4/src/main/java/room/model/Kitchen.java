package room.model;

import device.LedLamp;
import device.speaker.Speaker;
import device.thermostat.Thermostat;

public class Kitchen extends ARoom {

    public Kitchen(LedLamp ledLamp, Speaker speaker, Thermostat thermostat) {
        this.ledLamp = ledLamp;
        this.speaker = speaker;
        this.thermostat = thermostat;
    }
}
