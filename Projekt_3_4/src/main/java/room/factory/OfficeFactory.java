package room.factory;

import room.IRoom;
import room.builder.RoomBuilder;
import room.RoomType;

public class OfficeFactory implements IRoomFactory{
    @Override
    public IRoom createRoom() {
        return new RoomBuilder(RoomType.OFFICE)
                .build();
    }
}
