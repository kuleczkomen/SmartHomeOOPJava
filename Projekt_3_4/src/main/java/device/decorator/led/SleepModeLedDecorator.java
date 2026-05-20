package device.decorator.led;

import device.decorator.device.DeviceDecorator;
import device.decorator.device.ISleepModeBehaviour;
import device.model.IDevice;

public class SleepModeLedDecorator extends DeviceDecorator implements ISleepModeBehaviour {

    private int hour;

    public SleepModeLedDecorator(IDevice device, int hour) {
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

    private String sleepModeMesaage() {
        return "Tryb spania [blokuję działanie]...";
    }

    @Override
    public void switchOn() {
        if(isSleepTimeNow()) {
            IO.println(sleepModeMesaage());
        } else {
            super.switchOn();
        }
    }

    @Override
    public void switchOff() {
        if(isSleepTimeNow()) {
            IO.println(sleepModeMesaage());
        } else {
            super.switchOff();
        }
    }
}
