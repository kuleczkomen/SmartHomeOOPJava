package place;

import room.Bedroom;
import room.Ofiice;


public class FirstFloor implements IPlace {

    private final Bedroom bedroom;
    private final Ofiice ofiice;

    public FirstFloor(Bedroom bedroom, Ofiice ofiice) {
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
