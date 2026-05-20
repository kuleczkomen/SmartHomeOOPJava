package room.factory;

import room.model.IRoom;
import room.builder.RoomBuilder;
import room.model.Office;
import room.model.RoomType;

public class OfficeFactory implements IRoomFactory<Office>{
    @Override
    public Office createRoom() {
        return new RoomBuilder<>(Office::new)
                .build();
    }
}
