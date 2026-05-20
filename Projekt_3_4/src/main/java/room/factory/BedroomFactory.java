package room.factory;

import room.model.Bedroom;
import room.model.IRoom;
import room.builder.RoomBuilder;
import room.model.RoomType;

public class BedroomFactory implements IRoomFactory<Bedroom>{
    @Override
    public Bedroom createRoom() {
        return (Bedroom) new RoomBuilder<>(Bedroom::new)
                .withMaxVolume(30)
                .build();
    }
}
