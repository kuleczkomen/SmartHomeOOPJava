package device.speaker;

public class Speaker implements ISpeaker {

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
        IO.println("Speaker ON");
    }

    @Override
    public void switchOff() {
        isOn = false;
        IO.println("Speaker OFF");
    }

    @Override
    public boolean isOn() {
        return isOn;
    }

    @Override
    public String getInfo() {
        return "Głośnik Multiroom SoundMax";
    }

    @Override
    public void setVolume(int newVolume) {
        if(!isOn) {
            IO.println("Error: Can't change device parameter when it's off");
        } else if (newVolume > maxVolume) {
            IO.println("Too loud!!!");
        } else {
            volume = newVolume;
        }
    }

    @Override
    public void setMaxVolume(int newMaxVolume) {
        maxVolume = newMaxVolume;
    }

    public int getMaxVolume() {
        return maxVolume;
    }
}
