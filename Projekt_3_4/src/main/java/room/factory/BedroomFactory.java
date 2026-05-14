package room.factory;

import room.model.IRoom;
import room.builder.RoomBuilder;
import room.model.RoomType;

public class BedroomFactory implements IRoomFactory{
    @Override
    public IRoom createRoom() {
        return new RoomBuilder(RoomType.BEDROOM)
                .withMaxVolume(30)
                .build();
    }
}
