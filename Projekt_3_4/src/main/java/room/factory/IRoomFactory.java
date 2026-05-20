package room.factory;

import room.model.IRoom;

public interface IRoomFactory<T extends IRoom> {

    T createRoom();
}
