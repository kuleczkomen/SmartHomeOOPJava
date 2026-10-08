package room.strategy.scenario;

import org.junit.jupiter.api.Test;
import place.FirstFloor;
import place.GroundFloor;
import place.House;
import room.factory.*;
import room.model.IRoom;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

// integracyjny - nie ma mocków
public class PartyModeStrategyTest {

    private final KitchenFactory kitchenFactory = new KitchenFactory();
    private final BedroomFactory bedroomFactory = new BedroomFactory();
    private final LivingRoomFactory livingRoomFactory = new LivingRoomFactory();
    private final OfficeFactory officeFactory = new OfficeFactory();
    private final CorridorFactory corridorFactory = new CorridorFactory();

    @Test
    void applyPartyModeStrategyInHouse() {
        // given
        var house = getHouse();
        var sut = getSutBuilder().build();
        var livingRoom = house.getLivingRoom();

        // when
        sut.useScenario(house);

        // then
        assertThat(isEverythingSwitchedOnOnGroundFloorExceptLights(house)).isTrue();
        assertThat(livingRoom.getSpeaker().getVolume()).isEqualTo(house.getMaxVolumeIn(livingRoom));
        assertThat(areAllLightsSwitchedOffExceptLivingRoom(house)).isTrue();
        assertThat(livingRoom.getThermostat().getTemp()).isEqualTo(sut.getTempToSet());
    }

    private House getHouse() {
            return new House(
            new GroundFloor(
                kitchenFactory.createRoom(),
                livingRoomFactory.createRoom()
            ),
            new FirstFloor(bedroomFactory.createRoom(), officeFactory.createRoom()),
            corridorFactory.createRoom()
        );
    }

    private ScenarioBuilder<PartyModeStrategy> getSutBuilder() {
        return new ScenarioBuilder<>(
                PartyModeStrategy::new,
                ScenarioType.PARTY_MODE,
                "Impreza",
                List.of()
        );
    }

    private boolean isEverythingSwitchedOnOnGroundFloorExceptLights(House house) {
        List<IRoom> places = getGroundFloorPlaces(house.getGroundFloor());
        for(IRoom room : places) {
            if(!room.getSpeaker().isOn()) return false;
            if(!room.getThermostat().isOn()) return false;
        }
        return true;
    }

    private boolean areAllLightsSwitchedOffExceptLivingRoom(House house) {
        List<IRoom> places = getHousePlacesWithoutLivingRoom(house);
        for(IRoom room : places) {
            if(room.getLedLamp().isOn()) return false;
        }
        return house.getLivingRoom().getLedLamp().isOn();
    }

    private List<IRoom> getHousePlacesWithoutLivingRoom(House house) {
        return  List.of(
                house.getCorridor(),
                house.getBedrrom(),
                house.getOffice(),
                house.getKitchen()
        );
    }

    private List<IRoom> getGroundFloorPlaces(GroundFloor groundFloor) {
        return  List.of(
                groundFloor.getKitchen(),
                groundFloor.getLivingRoom()
        );
    }
}
