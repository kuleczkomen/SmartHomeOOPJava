
import command.ICommand;
import command.CommandRunner;
import command.SetVolumeEverywhereCommand;
import command.SwitchAllSpeakersCommand;
import device.model.IDevice;
import device.decorator.device.DetailedAuditDeviceDecator;
import device.decorator.speaker.SleepModeSpeakerDecorator;
import room.strategy.scenario.ScenarioBuilder;
import room.strategy.scenario.ScenarioType;
import room.strategy.thermostat.DayNightThermostatStrategy;
import place.Corridor;
import place.FirstFloor;
import place.GroundFloor;
import place.House;
import room.factory.*;

import room.model.Bedroom;
import room.model.Kitchen;
import room.model.LivingRoom;
import room.model.Office;
import room.strategy.scenario.EveningAuditStrategy;
import room.strategy.scenario.PartyModeStrategy;
import secureNewLegacyApiFacade.LegacySecureNetFacade;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        // tworzenie domu
        Kitchen kitchen = new KitchenFactory().createRoom();
        LivingRoom livingRoom = new LivingRoomFactory().createRoom();
        Bedroom bedroom = new BedroomFactory().createRoom();
        Office office = new OfficeFactory().createRoom();
        Corridor corridor = new CorridorFactory().createRoom();

        House house = new House(
                new GroundFloor(kitchen, livingRoom),
                new FirstFloor(bedroom, office),
                corridor
        );

        //  użycie systemu alarmowego
        System.out.println("--- SYSTEM ALARMOWY ---");
        var adapter = new LegacySecureNetFacade();
        adapter.armAlarm();
        adapter.checkSmokeSensor();

        // wywołanie scenariuszy
        System.out.println("--- AUDYT ---");
        var eveningAudit = new ScenarioBuilder(ScenarioType.EVENING_AUDIT, "Niedzielny audyt", List.of(7))
                .build();
        eveningAudit.runScenario(house);

        System.out.println("--- PARTY ---");
        var partyMode = new ScenarioBuilder(ScenarioType.PARTY_MODE, "Impra na dzielni", List.of())
                .withEmail("qwe@gmail.com")
                .withStartHour(0)
                .build();

        partyMode.runScenario(house);

        // test komendy
        System.out.println("--- KOMENDA ---");
        CommandRunner commandRunner = new CommandRunner();

        //  włączenie głośników wszędzie na 67
        System.out.println("--- Głośniki na 67 ---");
        ICommand switchOnAllSpeakers = new SwitchAllSpeakersCommand(house, true);
        commandRunner.executeCommand(switchOnAllSpeakers);

        ICommand speakersTo67 = new SetVolumeEverywhereCommand(house, 67);
        commandRunner.executeCommand(speakersTo67);
        System.out.println("Głośność w kuchni: %d".formatted(kitchen.getSpeaker().getVolume()));
        commandRunner.undoLastAction();
        System.out.println("Głośność w kuchni: %d".formatted(kitchen.getSpeaker().getVolume()));

        // termostat w trybie day/night
        var dayNightThermostat = new DayNightThermostatStrategy(corridor.getThermostat(), 0);

        for(int hour = 0; hour < 24; hour++) {
            if(hour == 4) {
                System.out.println("---- Sleep mode ----");
                IDevice sleepSpeaker = new SleepModeSpeakerDecorator(bedroom.getSpeaker(), hour);
                sleepSpeaker.switchOn();
                sleepSpeaker.switchOff();

                dayNightThermostat.setHour(hour);
                dayNightThermostat.setTemperature();
                System.out.println("Tempratura o %d:00: %d".formatted(hour, corridor.getThermostat().getTemp()));
            }

            if(hour == 12) {
                dayNightThermostat.setHour(hour);
                dayNightThermostat.setTemperature();
                System.out.println("Tempratura o %d:00: %d".formatted(hour, corridor.getThermostat().getTemp()));
            }
            if(hour == 23) {
                System.out.println("--- Szczegółowy Audyt o 23---");
                IDevice auditLamp = new DetailedAuditDeviceDecator(kitchen.getLedLamp(), 1, hour);
                auditLamp.switchOn();
                auditLamp.switchOff();
            }
        }
    }
}
