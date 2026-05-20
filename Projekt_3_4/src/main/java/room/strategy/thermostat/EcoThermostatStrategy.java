package room.strategy.thermostat;

import device.model.Thermostat;
import device.decorator.thermostat.ThermostatDecorator;

public class EcoThermostatStrategy extends ThermostatDecorator {

    public EcoThermostatStrategy(Thermostat thermostat) {
        super(thermostat);
    }

    @Override
    public void setTemp(int newTemp) {
        super.setTemp(17);
    }
}
