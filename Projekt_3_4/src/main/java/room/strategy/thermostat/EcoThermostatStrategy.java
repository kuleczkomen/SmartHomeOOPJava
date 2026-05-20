package room.strategy.thermostat;

import device.model.Thermostat;
import device.decorator.thermostat.ThermostatDecorator;

public class EcoThermostatStrategy extends AThermostatStrategy {

    public EcoThermostatStrategy(Thermostat thermostat) {
        super(thermostat);
    }

    @Override
    public void setTemperature() {
        thermostat.setTemp(17);
    }
}
