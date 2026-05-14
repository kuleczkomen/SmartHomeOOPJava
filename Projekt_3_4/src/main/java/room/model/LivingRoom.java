package room.model;

import device.LedLamp;
import device.Speaker;
import device.Thermostat;

public class LivingRoom extends ARoom{

    public LivingRoom(LedLamp ledLamp, Speaker speaker, Thermostat thermostat) {
        this.ledLamp = ledLamp;
        this.speaker = speaker;
        this.thermostat = thermostat;
    }


}
