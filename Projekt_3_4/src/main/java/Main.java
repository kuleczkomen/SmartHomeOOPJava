
import room.factory.BedroomFactory;
import room.factory.KitchenFactory;
import room.factory.LivingRoomFactory;
import room.factory.OfficeFactory;

import room.model.Kitchen;
import secureNewLegacyApiFacade.LegacySecureNetFacade;

public class Main {
    public static void main(String[] args) {

        Kitchen kitchen = new KitchenFactory().createRoom();
        LivingRoomFactory livingRoomFactory = new LivingRoomFactory();
        BedroomFactory bedroomFactory = new BedroomFactory();
        OfficeFactory officeFactory = new OfficeFactory();

        var adapter = new LegacySecureNetFacade();
//        adapter.armAlarm();
//        adapter.checkSmokeSensor();

        for(int hour = 0; hour < 24; hour++) {

        }
    }
}
