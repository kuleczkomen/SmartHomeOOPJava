package phones;

import java.util.List;

public class GPS implements BatteryDevice {

    private int batteryPercentage = 100;

    @Override
    public int getBattery() {
        return batteryPercentage;
    }

    @Override
    public void setBattery(int battery) {
        batteryPercentage = battery;
    }

    public void chargeWithPin() {
        setBattery(batteryPercentage + 15);
    }

    public List<Double> getLocation() {
        if(batteryPercentage > 5) {
            return List.of(42.18, 41.10);
        } else {
            System.out.println("Poziom baterii %d nie przekracza 5...");
            return List.of();
        }
    }

}
