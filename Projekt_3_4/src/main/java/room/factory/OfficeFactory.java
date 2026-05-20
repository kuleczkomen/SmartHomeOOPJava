package room.factory;

import room.model.IRoom;
import room.builder.RoomBuilder;
import room.model.Office;
import room.model.RoomType;

public class OfficeFactory implements IRoomFactory{
    @Override
    public Office createRoom() {
        return (Office) new RoomBuilder(RoomType.OFFICE)
                .build();
    }
}
