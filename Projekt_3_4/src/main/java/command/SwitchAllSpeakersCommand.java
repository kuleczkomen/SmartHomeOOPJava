package command;

import place.House;

public class SwitchAllSpeakersCommand implements ICommand{

    private final House house;
    private final boolean turnOn;

    public SwitchAllSpeakersCommand(House house, boolean turnOn) {
        this.house = house;
        this.turnOn = turnOn;
    }

    @Override
    public void execute() {
        if (turnOn) {
            house.switchOnAllSpeakers();
        } else {
            house.switchOffAllSpeakers();
        }
    }

    @Override
    public void undo() {
        // na odwrót
        if (turnOn) {
            house.switchOffAllSpeakers();
        } else {
            house.switchOnAllSpeakers();
        }
    }
}
