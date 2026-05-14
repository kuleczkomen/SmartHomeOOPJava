package device;

public class Speaker implements IDevice {

    private int volume;
    private int maxVolume;
    private boolean isOn = true;

    public Speaker(int volume, int maxVolume) {
        this.volume = volume;
        this.maxVolume = maxVolume;
    }

    @Override
    public void switchOn() {
        isOn = true;
        IO.println("ON");
    }

    @Override
    public void switchOff() {
        isOn = false;
        IO.println("OFF");
    }

    @Override
    public boolean isOn() {
        return isOn;
    }

    public void setVolume(int newVolume) {
        if(!isOn) {
            IO.println("Error: Can't change device parameter when it's off");
        } else if (newVolume > maxVolume) {
            IO.println("Too loud!!!");
        } else {
            volume = newVolume;
        }
    }

    public void setMaxVolume(int newMaxVolume) {
        maxVolume = newMaxVolume;
    }

    public int getMaxVolume() {
        return maxVolume;
    }
}
