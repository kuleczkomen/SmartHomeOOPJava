package place;

import room.model.IRoom;

public class House implements IPlace {

    private final GroundFloor groundFloor;
    private final FirstFloor firstFloor;
    private final Corridor corridor;

    public House(GroundFloor groundFloor, FirstFloor firstFloor, Corridor corridor) {
        this.groundFloor = groundFloor;
        this.firstFloor = firstFloor;
        this.corridor = corridor;
    }

    @Override
    public void switchOnEverything() {
        groundFloor.switchOnEverything();
        firstFloor.switchOnEverything();
        corridor.switchOnEverything();
    }

    @Override
    public void switchOffEverything() {
        groundFloor.switchOffEverything();
        firstFloor.switchOffEverything();
        corridor.switchOffEverything();
    }

    @Override
    public void switchOnAllSpeakers() {
        groundFloor.switchOnAllSpeakers();
        firstFloor.switchOnAllSpeakers();
        corridor.switchOnAllSpeakers();
    }

    @Override
    public void switchOnAllLights() {
        groundFloor.switchOnAllLights();
        firstFloor.switchOnAllLights();
        corridor.switchOnAllLights();
    }

    @Override
    public void switchOnAllThermostats() {
        groundFloor.switchOnAllThermostats();
        firstFloor.switchOnAllThermostats();
        corridor.switchOnAllThermostats();
    }

    @Override
    public void switchOffAllSpeakers() {
        groundFloor.switchOffAllSpeakers();
        firstFloor.switchOffAllSpeakers();
        corridor.switchOffAllSpeakers();
    }

    @Override
    public void switchOffAllLights() {
        groundFloor.switchOffAllLights();
        firstFloor.switchOffAllLights();
        corridor.switchOffAllLights();
    }

    @Override
    public void switchOffAllThermostats() {
        groundFloor.switchOffAllThermostats();
        firstFloor.switchOffAllThermostats();
        corridor.switchOffAllThermostats();
    }

    @Override
    public void setTempEverywhere(int temp) {
        groundFloor.setTempEverywhere(temp);
        firstFloor.setTempEverywhere(temp);
        corridor.setTempEverywhere(temp);
    }

    @Override
    public void setVolumeEverywhere(int volume) {
        groundFloor.setVolumeEverywhere(volume);
        firstFloor.setVolumeEverywhere(volume);
        corridor.setVolumeEverywhere(volume);
    }

    @Override
    public void setMaxVolumeEverywhrere(int volume) {
        groundFloor.setMaxVolumeEverywhrere(volume);
        firstFloor.setMaxVolumeEverywhrere(volume);
        corridor.setMaxVolumeEverywhrere(volume);
    }

    public GroundFloor getGroundFloor() {
        return groundFloor;
    }

    public FirstFloor getFirstFloor() {
        return firstFloor;
    }

    public Corridor getCorridor() {
        return corridor;
    }

    public int getMaxVolumeIn(IRoom room) {
        return room.getSpeaker().getMaxVolume();
    }
    public void setVolumeIn(IRoom room, int volume) {
        room.getSpeaker().setVolume(volume);
    }
}
