package device;

public class Speaker implements IDevice {

    private int volume;
    private boolean isOn;

    @Override
    public void switchOn() {
        isOn = true;
        IO.println("ON");
    }

    @Override
    public void switchOff() {
        isOn = false;
        IO.println("OFF");
    }

    @Override
    public boolean isOn() {
        return isOn;
    }

    public void setVolume(int newVolume) {
        if(!isOn) {
            IO.println("Error: Can't change device parameter when it's off");
        } else {
            volume = newVolume;
        }
    }
}
