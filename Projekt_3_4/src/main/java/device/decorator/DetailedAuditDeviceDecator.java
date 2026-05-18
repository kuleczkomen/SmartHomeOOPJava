package device.decorator;

import device.IDevice;

public class DetailedAuditDeviceDecator extends DeviceDecorator{

    private int day;
    private int hour;

    public DetailedAuditDeviceDecator(IDevice device, int day, int hour) {
        super(device);
        this.day = day;
        this.hour = hour;
    }

    @Override
    public void switchOn() {
        IO.println("[Dzień] %d | [Godzina] %d:00 %s".formatted(day, hour, super.getInfo()));
    }
}
