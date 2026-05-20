package room.builder;

import device.LedLamp;
import device.model.Speaker;
import device.model.Thermostat;
import room.model.*;

public class RoomBuilder<T extends IRoom> {

    private final RoomConstructor<T> constructor;

    private LedLamp ledLamp = new LedLamp();

    private int volume = 10;
    private int maxVolume = 100;
    private Speaker speaker = new Speaker(volume, maxVolume);

    private int temp = 20;
    private Thermostat thermostat = new Thermostat(temp);


    public RoomBuilder(RoomConstructor<T> constructor) {
        this.constructor = constructor;
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

    public T build() {
        return constructor.create(ledLamp, speaker, thermostat);
    }
}
