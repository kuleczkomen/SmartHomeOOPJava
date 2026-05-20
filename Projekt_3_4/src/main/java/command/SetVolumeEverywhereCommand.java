package command;

import place.House;

public class SetVolumeEverywhereCommand implements ICommand{

    private final House house;
    private final int prevVolume;
    private final int volume;

    public SetVolumeEverywhereCommand(House house, int volume) {
        this.house = house;
        this.volume = volume;
        prevVolume = 20;
    }

    @Override
    public void execute() {
        house.setVolumeEverywhere(volume);
    }

    @Override
    public void undo() {
        // na odwrót
        house.setVolumeEverywhere(prevVolume);
    }
}
