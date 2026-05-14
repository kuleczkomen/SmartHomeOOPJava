package room.factory;

import room.IRoom;
import room.builder.RoomBuilder;
import room.RoomType;

public class LivingRoomFactory implements IRoomFactory{
    @Override
    public IRoom createRoom() {
        return new RoomBuilder(RoomType.BEDROOM)
                .build();
    }
}
