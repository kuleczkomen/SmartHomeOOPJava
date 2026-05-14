package room.builder;

import device.LedLamp;
import device.Speaker;
import device.Thermostat;
import room.model.*;

public class RoomBuilder {

    private LedLamp ledLamp = new LedLamp();

    private int volume = 10;
    private int maxVolume = 100;
    private Speaker speaker = new Speaker(volume, maxVolume);

    private int temp = 20;
    private Thermostat thermostat = new Thermostat(temp);

    private final RoomType roomType;

    public RoomBuilder(RoomType roomType) {
        this.roomType = roomType;
    }

    public RoomBuilder withVolume(int volume) {
        this.volume = volume;
        return this;
    }

    public RoomBuilder withMaxVolume(int maxVolume) {
        this.maxVolume = maxVolume;
        return this;
    }

    public RoomBuilder withTemp(int temp) {
        this.temp = temp;
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
