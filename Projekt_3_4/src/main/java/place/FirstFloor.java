package place;

import room.Bedroom;
import room.Office;


public class FirstFloor implements IPlace {

    private final Bedroom bedroom;
    private final Office ofiice;

    public FirstFloor(Bedroom bedroom, Office ofiice) {
        this.bedroom = bedroom;
        this.ofiice = ofiice;
    }

    @Override
    public void switchOnEverything() {

    }

    @Override
    public void switchOffEverything() {

    }
}
