import secureNetLegacyApi.facade.LegacySecureNetFacade;

public class Main {
    public static void main(String[] args) {

        var adapter = new LegacySecureNetFacade();
        adapter.armAlarm();
        adapter.checkSmokeSensor();

        for(int hour = 0; hour < 24; hour++) {

        }
    }
}
