package room.factory;

import room.model.Bedroom;
import room.model.IRoom;
import room.builder.RoomBuilder;
import room.model.RoomType;

public class BedroomFactory implements IRoomFactory{
    @Override
    public Bedroom createRoom() {
        return (Bedroom) new RoomBuilder(RoomType.BEDROOM)
                .withMaxVolume(30)
                .build();
    }
}
