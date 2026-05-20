package room.strategy.thermostat;

import device.model.Thermostat;

public abstract class AThermostatStrategy implements IThermostatStrategy{

    protected Thermostat thermostat;

    public AThermostatStrategy(Thermostat thermostat) {
        this.thermostat = thermostat;
    }

}
