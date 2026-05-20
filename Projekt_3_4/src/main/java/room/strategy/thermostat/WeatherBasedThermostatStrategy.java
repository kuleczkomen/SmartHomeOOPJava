package room.strategy.thermostat;

import device.model.Thermostat;
import device.decorator.thermostat.ThermostatDecorator;

public class WeatherBasedThermostatStrategy extends AThermostatStrategy {

    private int tempOutside;

    public WeatherBasedThermostatStrategy(Thermostat thermostat, int tempOutside) {
        super(thermostat);
        this.tempOutside = tempOutside;
    }

    @Override
    public void setTemperature()  {
        if(tempOutside < 10) {
            thermostat.setTemp(23);
        } else {
            thermostat.setTemp(20);
        }
    }
}
