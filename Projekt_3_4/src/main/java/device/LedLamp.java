package device;

public class LedLamp implements Device {

    @Override
    public void switchOn() {
        IO.println("ON");
    }

    @Override
    public void switchOff() {
        IO.println("OFF");
    }
}
