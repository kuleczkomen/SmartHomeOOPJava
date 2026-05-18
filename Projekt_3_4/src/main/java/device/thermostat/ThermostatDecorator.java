package device.thermostat;

public class ThermostatDecorator implements IThermostat{

    private Thermostat inner;

    public ThermostatDecorator(Thermostat thermostat) {
        this.inner = thermostat;
    }

    @Override
    public void setTemp(int newTemp) {
        inner.setTemp(newTemp);
    }

    @Override
    public void switchOn() {
        inner.switchOn();
    }

    @Override
    public void switchOff() {
        inner.switchOff();
    }

    @Override
    public boolean isOn() {
        return inner.isOn();
    }
}
