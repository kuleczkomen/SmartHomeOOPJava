package device.thermostat;

public class Thermostat implements IThermostat {

    private int temp;
    private boolean isOn = true;

    public Thermostat(int temp) {
        this.temp = temp;
    }

    @Override
    public void switchOn() {
        isOn = true;
        IO.println("Thermostat ON");
    }

    @Override
    public void switchOff() {
        isOn = false;
        IO.println("Thermostat OFF");
    }

    @Override
    public boolean isOn() {
        return isOn;
    }

    @Override
    public String getInfo() {
        return "Termostat ThermoPro";
    }

    @Override
    public void setTemp(int newTemp) {
        if(!isOn) {
            IO.println("Error: Can't change device parameter when it's off");
        } else {
            temp = newTemp;
        }
    }
}
