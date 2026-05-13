package room;

import device.LedLamp;
import device.Speaker;
import device.Thermostat;

public class RoomBuilder {

    private LedLamp ledLamp;
    private Speaker speaker;
    private Thermostat thermostat;

    public RoomBuilder withLedLamp(LedLamp ledLamp) {
        this.ledLamp = ledLamp;
        return this;
    }

    public RoomBuilder withSpeaker(Speaker speaker) {
        this.speaker = speaker;
        return this;
    }

    public RoomBuilder withThermostat(Thermostat thermostat) {
        this.thermostat = thermostat;
        return this;
    }

    public IRoom build() {
        return new IRoom(ledLamp, speaker, thermostat);
    }
}
