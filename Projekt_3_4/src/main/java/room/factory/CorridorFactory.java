package room.factory;

import place.Corridor;
import room.builder.RoomBuilder;
import room.model.Bedroom;
import room.model.RoomType;

public class CorridorFactory implements IRoomFactory<Corridor> {
    @Override
    public Corridor createRoom() {
        return new RoomBuilder<>(Corridor::new)
                .build();
    }
}
