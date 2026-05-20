package device.decorator.thermostat;

import device.decorator.device.ISleepModeBehaviour;
import device.model.Thermostat;

public class SleepModeThermostatDecorator extends ThermostatDecorator implements ISleepModeBehaviour {

    private int hour;

    public SleepModeThermostatDecorator(Thermostat thermostat) {
        super(thermostat);
    }

    @Override
    public int getHour() {
        return hour;
    }

    @Override
    public void setHour(int newHour) {
        hour = newHour;
    }

    @Override
    public void setAutoTemp() {
        super.setAutoTemp();
    }

    @Override
    public void switchOn() {
        if (isSleepTimeNow()) {
            IO.println("Tryb spania...");
        } else {
            super.switchOn();
        }
    }

    @Override
    public void switchOff() {
        if (isSleepTimeNow()) {
            IO.println("Tryb spania...");
        } else {
            super.switchOff();
        }
    }
}
