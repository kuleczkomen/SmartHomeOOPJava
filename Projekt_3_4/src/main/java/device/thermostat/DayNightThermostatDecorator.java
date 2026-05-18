package device.thermostat;

public class DayNightThermostatDecorator extends ThermostatDecorator{

    private int hour;

    public DayNightThermostatDecorator(Thermostat thermostat, int hour) {
        super(thermostat);
        this.hour = hour;
    }

    public void setHour(int newHour) {
        hour = newHour;
    }

    @Override
    public void setAutoTemp() {
        if(hour >= 8 && hour <= 22) {
            super.setTemp(22);
        } else {
            super.setTemp(19);
        }
    }


}
