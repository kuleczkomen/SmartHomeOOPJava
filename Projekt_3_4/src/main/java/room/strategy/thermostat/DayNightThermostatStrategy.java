package room.strategy.thermostat;

import device.model.IThermostat;
import device.model.Thermostat;
import device.decorator.thermostat.ThermostatDecorator;

public class DayNightThermostatStrategy extends AThermostatStrategy {

    private int hour;

    public DayNightThermostatStrategy(Thermostat thermostat, int hour) {
        super(thermostat);
        this.hour = hour;
    }


    @Override
    public void setTemperature() {
        if(hour >= 8 && hour <= 22) {
            thermostat.setTemp(22);
        } else {
            thermostat.setTemp(19);
        }
    }
}
