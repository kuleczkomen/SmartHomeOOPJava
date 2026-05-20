package room.factory;

import place.Corridor;
import room.builder.RoomBuilder;
import room.model.RoomType;

public class CorridorFactory implements IRoomFactory {
    @Override
    public Corridor createRoom() {
        return (Corridor) new RoomBuilder(RoomType.CORRIDOR)
                .build();
    }
}
