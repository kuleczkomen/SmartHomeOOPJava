package room.factory;

import room.IRoom;

public interface IRoomFactory {

    IRoom createRoom();

    default void setupRoom() {
        IRoom room = createRoom();
    }
}
