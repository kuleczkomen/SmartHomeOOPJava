package place;

public class House implements IPlace {

    private final GroundFloor groundFloor;
    private final FirstFloor firstFloor;

    public House(GroundFloor groundFloor, FirstFloor firstFloor) {
        this.groundFloor = groundFloor;
        this.firstFloor = firstFloor;
    }


    @Override
    public void switchOnEverything() {
        groundFloor.switchOnEverything();
        firstFloor.switchOnEverything();
    }

    @Override
    public void switchOffEverything() {
        groundFloor.switchOffEverything();
        firstFloor.switchOffEverything();
    }
}
