
import command.ICommand;
import command.CommandRunner;
import command.SetVolumeEverywhereCommand;
import command.SwitchAllSpeakersCommand;
import device.IDevice;
import device.decorator.DetailedAuditDeviceDecator;
import place.Corridor;
import place.FirstFloor;
import place.GroundFloor;
import place.House;
import room.factory.*;

import room.model.Bedroom;
import room.model.Kitchen;
import room.model.LivingRoom;
import room.model.Office;
import room.strategy.EveningAuditStrategy;
import room.strategy.PartyModeStrategy;
import secureNewLegacyApiFacade.LegacySecureNetFacade;

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
        var eveningAudit = new EveningAuditStrategy();
        eveningAudit.runScenario(house);

        System.out.println("--- PARTY ---");
        var partyMode = new PartyModeStrategy();
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


        for(int hour = 0; hour < 24; hour++) {
            if(hour == 4) {
                System.out.println("---- Sleep mode ----");
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
