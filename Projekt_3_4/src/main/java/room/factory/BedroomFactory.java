package room.factory;

import room.IRoom;
import room.builder.RoomBuilder;
import room.RoomType;

public class BedroomFactory implements IRoomFactory{
    @Override
    public IRoom createRoom() {
        return new RoomBuilder(RoomType.BEDROOM)
                .withMaxVolume(30)
                .build();
    }
}
