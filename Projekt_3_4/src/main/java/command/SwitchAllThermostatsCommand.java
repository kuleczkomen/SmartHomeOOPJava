package command;

import place.House;

public class SwitchAllThermostatsCommand implements ICommand{

    private final House house;
    private final boolean turnOn;

    public SwitchAllThermostatsCommand(House house, boolean turnOn) {
        this.house = house;
        this.turnOn = turnOn;
    }

    @Override
    public void execute() {
        if (turnOn) {
            house.switchOnAllThermostats();
        } else {
            house.switchOffAllThermostats();
        }
    }

    @Override
    public void undo() {
        // na odwrót
        if (turnOn) {
            house.switchOffAllThermostats();
        } else {
            house.switchOnAllThermostats();
        }
    }
}
