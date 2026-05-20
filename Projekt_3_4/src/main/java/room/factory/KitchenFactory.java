package room.factory;

import room.model.IRoom;
import room.builder.RoomBuilder;
import room.model.Kitchen;
import room.model.RoomType;

public class KitchenFactory implements IRoomFactory {

    @Override
    public IRoom createRoom() {
        return new RoomBuilder(RoomType.KITCHEN)
                .build();
    }
}
