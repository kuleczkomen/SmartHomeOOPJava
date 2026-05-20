package device.decorator.speaker;

import device.model.ISpeaker;

public class SpeakerDecorator implements ISpeaker {

    protected final ISpeaker inner;

    public SpeakerDecorator(ISpeaker speaker) {
        this.inner = speaker;
    }

    @Override
    public void setVolume(int newVolume) {
        inner.setVolume(newVolume);
    }

    @Override
    public void setMaxVolume(int newMaxVolume) {
        inner.setMaxVolume(newMaxVolume);
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