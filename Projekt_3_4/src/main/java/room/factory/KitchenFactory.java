package room.factory;

import room.model.IRoom;
import room.builder.RoomBuilder;
import room.model.Kitchen;
import room.model.RoomType;

public class KitchenFactory implements IRoomFactory<Kitchen> {

    @Override
    public Kitchen createRoom() {
        return new RoomBuilder<>(Kitchen::new)
                .build();
    }
}
