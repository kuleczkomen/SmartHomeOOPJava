package place;

import room.model.Bedroom;
import room.model.Office;


public class FirstFloor implements IPlace {

    private final Bedroom bedroom;
    private final Office office;

    public FirstFloor(Bedroom bedroom, Office office) {
        this.bedroom = bedroom;
        this.office = office;
    }

    @Override
    public void switchOnEverything() {

    }

    @Override
    public void switchOffEverything() {

    }

    @Override
    public void switchOffAllSpeakers() {
        bedroom.getSpeaker().switchOff();
        office.getSpeaker().switchOff();
    }

    public Bedroom getBedroom() {
        return bedroom;
    }

    public Office getOffice() {
        return office;
    }
}
