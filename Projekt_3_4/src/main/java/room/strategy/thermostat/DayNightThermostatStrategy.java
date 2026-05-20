package room.strategy.thermostat;

import device.model.IThermostat;
import device.model.Thermostat;
import device.decorator.thermostat.ThermostatDecorator;

public class DayNightThermostatStrategy implements IThermostatStrategy {

    @Override
    public int chooseTemperature(int hour) {
        if(hour >= 8 && hour <= 22) {
            return 22;
        } else {
            return 19;
        }
    }
}
