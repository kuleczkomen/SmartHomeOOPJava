package device;

public class Thermostat implements IDevice {

    private int temp;
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

    public void setTemp(int newTemp) {
        if(!isOn) {
            IO.println("Error: Can't change device parameter when it's off");
        } else {
            temp = newTemp;
        }
    }
}
