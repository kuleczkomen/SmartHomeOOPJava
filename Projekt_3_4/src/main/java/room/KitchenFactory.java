package room;

public class KitchenFactory implements IRoomFactory {

    @Override
    public IRoom createRoom() {
        Kitchen kitchen = new Kitchen();
        return kitchen;
    }
}
