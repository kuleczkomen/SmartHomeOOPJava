package device.speaker;

import device.IDevice;

public interface ISpeaker extends IDevice {
    void setVolume(int newVolume);
    void setMaxVolume(int newMaxVolume);
}
