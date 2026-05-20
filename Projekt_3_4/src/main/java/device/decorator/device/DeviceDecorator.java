package device.decorator.device;

import device.model.IDevice;

public class DeviceDecorator implements IDevice {

    private IDevice inner;

    public DeviceDecorator(IDevice device) {
        inner = device;
    }

    @Override
    public void switchOn() {
        inner.switchOn();
    }

    @Override
    public void switchOff() {
        inner.switchOff();
    }

    @Override
    public boolean isOn() {
        return inner.isOn();
    }

    @Override
    public String getInfo() {
        return inner.getInfo();
    }
}
