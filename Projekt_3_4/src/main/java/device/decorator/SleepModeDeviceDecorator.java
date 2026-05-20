package device.decorator;

import device.IDevice;
import device.ISleepModeBehaviour;

public class SleepModeDeviceDecorator extends DeviceDecorator implements ISleepModeBehaviour {

    private int hour;

    public SleepModeDeviceDecorator(IDevice device, int hour) {
        super(device);
        this.hour = hour;
    }

    @Override
    public int getHour() {
        return hour;
    }

    @Override
    public void setHour(int newHour) {
        hour = newHour;
    }

    @Override
    public void switchOn() {
        if(isSleepTimeNow()) {
            IO.println("Tryb spania...");
        } else {
            super.switchOn();
        }
    }

    @Override
    public void switchOff() {
        if(isSleepTimeNow()) {
            IO.println("Tryb spania...");
        } else {
            super.switchOff();
        }
    }
}
