package device.model;

public interface IThermostat extends IDevice {
    void setTemp(int newTemp);
    default void setAutoTemp() {
        setTemp(20);
    }
}
