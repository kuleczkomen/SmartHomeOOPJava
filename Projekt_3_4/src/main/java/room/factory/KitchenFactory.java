package room.factory;

import room.IRoom;
import room.builder.RoomBuilder;
import room.RoomType;

public class KitchenFactory implements IRoomFactory {

    @Override
    public IRoom createRoom() {
        return new RoomBuilder(RoomType.KITCHEN)
                .build();
    }
}
