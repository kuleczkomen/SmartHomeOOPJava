package room;

import device.LedLamp;
import device.Speaker;
import device.Thermostat;

public class RoomBuilder {

    private LedLamp ledLamp;
    private Speaker speaker;
    private Thermostat thermostat;
    private RoomType roomType = null;

    public RoomBuilder() {}

    public RoomBuilder withRoomType(RoomType roomType) {
        this.roomType = roomType;
        return this;
    }

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

    // lekka gimnastyka, żeby nie tworzyć osobnego buildera dla każdego Rooma
    public IRoom build() {
        return switch (roomType) {
            case BEDROOM -> new Bedroom(ledLamp, speaker, thermostat);
            case KITCHEN -> new Kitchen(ledLamp, speaker, thermostat);
            case LIVINGROOM -> new LivingRoom(ledLamp, speaker, thermostat);
            case OFFICE -> new Office(ledLamp, speaker, thermostat);
        };
    }
}
