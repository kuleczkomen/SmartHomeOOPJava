package place;

import room.model.IRoom;

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

    @Override
    public void switchOffAllSpeakers() {
        groundFloor.switchOffAllSpeakers();
        firstFloor.switchOffAllSpeakers();
    }

    @Override
    public void switchOffAllLights() {
        groundFloor.switchOffAllLights();
        firstFloor.switchOffAllLights();
    }

    @Override
    public void switchOffAllThermostats() {
        groundFloor.switchOffAllThermostats();
        firstFloor.switchOffAllThermostats();
    }

    public GroundFloor getGroundFloor() {
        return groundFloor;
    }

    public FirstFloor getFirstFloor() {
        return firstFloor;
    }

    public int getMaxVolumeIn(IRoom room) {
        return room.getSpeaker().getMaxVolume();
    }
    public void setVolumeIn(IRoom room, int volume) {
        room.getSpeaker().setVolume(volume);
    }
}
