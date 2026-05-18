package device.thermostat;

public class EcoThermostatDecorator extends ThermostatDecorator{

    public EcoThermostatDecorator(Thermostat thermostat) {
        super(thermostat);
    }

    @Override
    public void setTemp(int newTemp) {
        super.setTemp(17);
    }
}
