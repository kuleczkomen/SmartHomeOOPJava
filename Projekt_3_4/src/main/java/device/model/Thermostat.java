package device.model;

public class Thermostat implements IThermostat {

    private int temp;
    private boolean isOn = true;
    private IThermostatStrategy strategy;

    public Thermostat(int temp) {
        this.temp = temp;
    }

    public void setStrategy(IThermostatStrategy strategy) {
        this.strategy = strategy;
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

    public int getTemp() {
        return temp;
    }
}
