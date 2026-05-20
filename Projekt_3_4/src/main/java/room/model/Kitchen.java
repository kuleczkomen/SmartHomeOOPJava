package room.model;

import device.LedLamp;
import device.model.Speaker;
import device.model.Thermostat;

public class Kitchen extends ARoom {

    public Kitchen(LedLamp ledLamp, Speaker speaker, Thermostat thermostat) {
        this.ledLamp = ledLamp;
        this.speaker = speaker;
        this.thermostat = thermostat;
    }
}
