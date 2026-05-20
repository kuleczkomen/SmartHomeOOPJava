package device.decorator.speaker;

import device.decorator.device.ISleepModeBehaviour;
import device.model.ISpeaker;

public class SleepModeSpeakerDecorator extends SpeakerDecorator implements ISleepModeBehaviour {

    private int hour;

    public SleepModeSpeakerDecorator(ISpeaker speaker, int hour) {
        super(speaker);
        this.hour = hour;
    }

    @Override
    public int getHour() {
        return hour;
    }

    @Override
    public void setHour(int newHour) {
        this.hour = newHour;
    }

    @Override
    public void setVolume(int newVolume) {
        if (isSleepTimeNow()) {
            IO.println("Tryb spania...");
        } else {
            super.setVolume(newVolume);
        }
    }

    @Override
    public void setMaxVolume(int newMaxVolume) {
        if (isSleepTimeNow()) {
            IO.println("Tryb spania...");
        } else {
            super.setMaxVolume(newMaxVolume);
        }
    }

    @Override
    public void switchOn() {
        if (isSleepTimeNow()) {
            IO.println("Tryb spania...");
        } else {
            super.switchOn();
        }
    }

    @Override
    public void switchOff() {
        if (isSleepTimeNow()) {
            IO.println("Tryb spania...");
        } else {
            super.switchOff();
        }
    }
}