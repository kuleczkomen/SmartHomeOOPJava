package command;

import place.House;

import java.util.HashMap;

public class SwitchEvertyhingCommand implements ICommand{

    private final House house;
    private final boolean turnOn;

    public SwitchEvertyhingCommand(House house, boolean turnOn) {
        this.house = house;
        this.turnOn = turnOn;
    }

    @Override
    public void execute() {
        if (turnOn) {
            house.switchOnEverything();
        } else {
            house.switchOffEverything();
        }
    }

    @Override
    public void undo() {
        // na odwrót
        if (turnOn) {
            house.switchOffEverything();
        } else {
            house.switchOnEverything();
        }
    }
}
