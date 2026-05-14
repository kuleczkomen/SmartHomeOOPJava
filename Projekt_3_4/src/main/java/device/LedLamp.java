package device;

public class LedLamp implements IDevice {

    private boolean isOn = true;

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
}
