package command.test.java.device.model;

import device.model.Thermostat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// unit
public class ThermostatTest {

    private int prevTemp;
    private int newTemp;

    @BeforeEach
    void setUp() {
        prevTemp = 13;
        newTemp = 67;
    }

    @Test
    void setTempWhenThermostatIsOffIsRejected() {
        // given
        Thermostat thermostat = new Thermostat(prevTemp);
        thermostat.switchOff();
        int expected = prevTemp;

        // when
        thermostat.setTemp(newTemp);

        // then
        assertEquals(expected, thermostat.getTemp());
    }

    @Test
    void setTempWhenThermostatIsOn() {
        // given
        Thermostat thermostat = new Thermostat(prevTemp);
        thermostat.switchOn();
        int expected = newTemp;

        // when
        thermostat.setTemp(newTemp);

        // then
        assertEquals(expected, thermostat.getTemp());
    }
}
