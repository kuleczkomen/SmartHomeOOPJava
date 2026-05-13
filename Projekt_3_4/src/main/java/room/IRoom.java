package room;

import device.IDevice;

import java.util.List;

public interface IRoom {

    void addDevice(IDevice device);

    List<IDevice> getDevices();
}
