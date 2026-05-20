package room.strategy.thermostat;

import device.model.Thermostat;

public abstract class AThermostatStrategy {

    protected Thermostat thermostat;

    public AThermostatStrategy(Thermostat thermostat) {
        this.thermostat = thermostat;
    }

    public abstract void setTemperature();
}
