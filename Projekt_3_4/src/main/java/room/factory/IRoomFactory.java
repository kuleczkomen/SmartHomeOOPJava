package room.factory;

import room.model.IRoom;

public interface IRoomFactory {

    IRoom createRoom();

    default void setupRoom() {
        IRoom room = createRoom();
    }
}
