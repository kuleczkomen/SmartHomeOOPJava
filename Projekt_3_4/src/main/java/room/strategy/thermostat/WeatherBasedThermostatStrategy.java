package room.strategy.thermostat;

import device.model.Thermostat;
import device.decorator.thermostat.ThermostatDecorator;

public class WeatherBasedThermostatStrategy extends ThermostatDecorator {

    private int tempOutside;

    public WeatherBasedThermostatStrategy(Thermostat thermostat, int temp) {
        super(thermostat);
        tempOutside = temp;
    }

    public void setTempOutside(int newTemp) {
        tempOutside = newTemp;
    }

    @Override
    public void setAutoTemp() {
        if(tempOutside < 10) {
            super.setTemp(23);
        } else {
            super.setTemp(20);
        }
    }
}
