package room.factory;

import room.model.IRoom;
import room.builder.RoomBuilder;
import room.model.Kitchen;
import room.model.LivingRoom;
import room.model.RoomType;

public class LivingRoomFactory implements IRoomFactory<LivingRoom>{
    @Override
    public LivingRoom createRoom() {
        return new RoomBuilder<>(LivingRoom::new)
                .build();
    }
}
