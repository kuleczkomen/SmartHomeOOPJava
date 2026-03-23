package phones;

// I - interface segregation
public interface Phone extends BatteryDevice {
    void call(String number);
    void sendSms(String number, String message);
    void chargeWithPin();


}
