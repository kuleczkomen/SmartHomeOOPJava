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

    private void auditLog() {
        IO.println("[Dzień] %d | [Godzina] %d:00 | %s".formatted(day, hour, super.getInfo()));
    }

    @Override
    public void switchOn() {
        auditLog();
        super.switchOn();
    }

    @Override
    public void switchOff() {
        auditLog();
        super.switchOff();
    }
}
