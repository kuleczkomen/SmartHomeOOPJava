package room;

public interface IRoomFactory {

    IRoom createRoom();

    default void setupRoom() {
        IRoom room = createRoom();
    }
}
