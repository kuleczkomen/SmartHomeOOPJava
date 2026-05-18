package device;

public interface ISpeaker extends IDevice{
    void setVolume(int newVolume);
    void setMaxVolume(int newMaxVolume);
}
