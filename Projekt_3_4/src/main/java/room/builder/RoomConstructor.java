package room.builder;

import device.LedLamp;
import device.model.Speaker;
import device.model.Thermostat;
import room.model.IRoom;

// lekka gimnastyka, aby nie tworzyć osobnego buildera dla każego pokuju
// ani nie tworzyc switcha we wspólnym builderze
@FunctionalInterface
public interface RoomConstructor<T extends IRoom>{

    T create(LedLamp lamp, Speaker speaker, Thermostat thermostat);
}
