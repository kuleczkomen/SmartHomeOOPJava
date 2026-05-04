package place;

import device.Device;

import java.util.List;

public interface Room {

    void addDevice(Device device);

    List<Device> getDevices();
}
