package room.strategy.thermostat;

import device.model.Thermostat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.IntStream;

// parametryzowany
public class DayAndNightThermostatTest {

    private Thermostat thermostat;
    private DayNightThermostatStrategy sut;

    static IntStream allHours() {
        // uwzględniam po jednej godzinie poza krańcami zakresu [0,23]
        return IntStream.rangeClosed(-1, 24);
    }

    @BeforeEach
    void mySetUp() {
        thermostat = new Thermostat(67);
        sut = new DayNightThermostatStrategy(thermostat, 0);
    }

    @ParameterizedTest
    @MethodSource("allHours")
    void setTemp(int hour) {
        // given
        int prevTemp = thermostat.getTemp();
        int expected = getExpectedTemp(hour, prevTemp);

        // when
        sut.setHourThenTemp(hour);

        // then
        if ((hour < 0 || hour >= 24)) {
            assertEquals(prevTemp, thermostat.getTemp());
        } else {
            assertEquals(expected, thermostat.getTemp());
        }
    }

    private int getExpectedTemp(int hour, int prevTemp) {
        if(hour < 0 || hour >= 24) {
            return prevTemp;
        }
        if(hour >= sut.getDayStartHour() && hour <= sut.getDayEndHour()) {
            return sut.getDayTemp();
        }
        return sut.getNightTemp();
    }


}
