package command.test.java.device.decorator.thermostat;

import device.decorator.thermostat.SleepModeThermostatDecorator;
import device.model.Thermostat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

// parametryzowany z fluid assertions
public class SleepModeThermostatDecoratorTest {

    private int prevTemp;
    private int newTemp;
    private Thermostat thermostat;
    private SleepModeThermostatDecorator sut;

    @BeforeEach
    void setUp() {
        prevTemp = 13;
        newTemp = 67;
        thermostat = new Thermostat(prevTemp);
        sut = new SleepModeThermostatDecorator(thermostat);
    }

    @ParameterizedTest
    @MethodSource("sleepHoursProvider")
    void setTempInSleepModeHours(int hour) {
        // given
        sut.setHour(hour);

        // when
        sut.setTemp(newTemp);

        // then
        assertThat(thermostat.getTemp()).isEqualTo(prevTemp);
    }

    @ParameterizedTest
    @MethodSource("nonSleepHoursProvider")
    void setTempInNonSleepModeHours(int hour) {
        // given
        sut.setHour(hour);

        // when
        sut.setTemp(newTemp);

        // then
        assertThat(thermostat.getTemp()).isEqualTo(newTemp);
    }

    private static IntStream sleepHoursProvider() {
        var sutProvider = new SleepModeThermostatDecorator(new Thermostat(0));
        int start = sutProvider.getStartHour();
        int end = sutProvider.getEndHour();

        return IntStream.concat(
                IntStream.rangeClosed(start, 23),
                IntStream.rangeClosed(0, end)
        );
    }

    private static IntStream nonSleepHoursProvider() {
        var sutProvider = new SleepModeThermostatDecorator(new Thermostat(0));
        int start = sutProvider.getStartHour();
        int end = sutProvider.getEndHour();

        return IntStream.rangeClosed(end + 1, start - 1);
    }
}
