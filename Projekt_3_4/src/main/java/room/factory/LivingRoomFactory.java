package room.factory;

import room.model.IRoom;
import room.builder.RoomBuilder;
import room.model.LivingRoom;
import room.model.RoomType;

public class LivingRoomFactory implements IRoomFactory{
    @Override
    public LivingRoom createRoom() {
        return (LivingRoom) new RoomBuilder(RoomType.LIVINGROOM)
                .build();
    }
}
