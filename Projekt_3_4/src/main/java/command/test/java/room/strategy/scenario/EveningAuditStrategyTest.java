package command.test.java.room.strategy.scenario;

import device.model.Thermostat;
import org.junit.jupiter.api.Test;
import place.FirstFloor;
import place.GroundFloor;
import place.House;
import room.model.Bedroom;
import room.strategy.scenario.EveningAuditStrategy;
import room.strategy.scenario.ScenarioBuilder;
import room.strategy.scenario.ScenarioType;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import java.util.List;

// londyński unit - z mockami
public class EveningAuditStrategyTest {

    @Test
    void applyEveningAuditStrategyInHouse() {
        // given
        var sut = new ScenarioBuilder<>(
                EveningAuditStrategy::new,
                ScenarioType.EVENING_AUDIT,
                "Niedzielny audyt",
                List.of())
                .build();

        House houseMock = mock(House.class);
        GroundFloor groundFloorMock = mock(GroundFloor.class);
        FirstFloor firstFloorMock = mock(FirstFloor.class);
        Bedroom bedroomMock = mock(Bedroom.class);
        Thermostat thermostatMock = mock(Thermostat.class);

        when(houseMock.getGroundFloor()).thenReturn(groundFloorMock);
        when(houseMock.getFirstFloor()).thenReturn(firstFloorMock);
        when(firstFloorMock.getBedroom()).thenReturn(bedroomMock);
        when(bedroomMock.getThermostat()).thenReturn(thermostatMock);

        int tempToSet = sut.getTempToSet();

        // when
        sut.runScenario(houseMock);

        // then
        verify(houseMock).switchOffAllSpeakers();
        verify(groundFloorMock).switchOffAllLights();
        verify(thermostatMock).setTemp(tempToSet);

    }
}
