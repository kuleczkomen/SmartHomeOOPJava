package device.thermostat;

public class WeatherBasedThermostatDecorator extends ThermostatDecorator{

    private int tempOutside;

    public WeatherBasedThermostatDecorator(Thermostat thermostat, int temp) {
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
