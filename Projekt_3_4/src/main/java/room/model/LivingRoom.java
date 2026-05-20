package room.model;

import device.LedLamp;
import device.model.Speaker;
import device.model.Thermostat;

public class LivingRoom extends ARoom{

    public LivingRoom(LedLamp ledLamp, Speaker speaker, Thermostat thermostat) {
        this.ledLamp = ledLamp;
        this.speaker = speaker;
        this.thermostat = thermostat;
    }


}
