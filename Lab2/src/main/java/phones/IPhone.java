package phones;

import java.util.List;

public interface IPhone extends BatteryDevice {
    void call(String number);
    void sendSms(String number, String message);
    void chargeWithThinPin();
    void connectToGPS(GPS gps);
    List<Double> getPhoneLocation();
}