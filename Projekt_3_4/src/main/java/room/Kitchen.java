package room;

import device.IDevice;
import device.LedLamp;
import device.Thermostat;

import java.util.List;

public class Kitchen implements IRoom{

    private LedLamp lamp;
    private Thermostat thermostat;


    @Override
    public void addDevice(IDevice device) {

    }

    @Override
    public List<IDevice> getDevices() {
        return List.of();
    }
}
