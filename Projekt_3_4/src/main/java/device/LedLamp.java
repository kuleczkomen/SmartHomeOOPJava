package device;

public class LedLamp implements IDevice {

    private boolean isOn = true;

    @Override
    public void switchOn() {
        isOn = true;
        IO.println("Lamp ON");
    }

    @Override
    public void switchOff() {
        isOn = false;
        IO.println("Lamp OFF");
    }

    @Override
    public boolean isOn() {
        return isOn;
    }
}
