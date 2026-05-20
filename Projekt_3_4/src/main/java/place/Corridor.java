package place;


import device.LedLamp;
import device.model.Speaker;
import device.model.Thermostat;
import room.model.ARoom;

// jest tak po środku (na półpiętrze) hehe
// więc traktuję go jako piętro (bo jest bezpośrednio podpięty do House)
// oraz ma swoje urządzenia

public class Corridor extends ARoom implements IPlace {

    public Corridor(LedLamp ledLamp, Speaker speaker, Thermostat thermostat) {
        this.ledLamp = ledLamp;
        this.speaker = speaker;
        this.thermostat = thermostat;
    }

    @Override
    public void switchOnEverything() {
        ledLamp.switchOn();
        speaker.switchOn();
        thermostat.switchOn();
    }

    @Override
    public void switchOffEverything() {
        ledLamp.switchOff();
        speaker.switchOff();
        thermostat.switchOff();
    }

    @Override
    public void switchOnAllSpeakers() {
        speaker.switchOn();
    }

    @Override
    public void switchOnAllLights() {
        ledLamp.switchOn();
    }

    @Override
    public void switchOnAllThermostats() {
        thermostat.switchOn();
    }

    @Override
    public void switchOffAllSpeakers() {
        speaker.switchOff();
    }

    @Override
    public void switchOffAllLights() {
        ledLamp.switchOff();
    }

    @Override
    public void switchOffAllThermostats() {
        thermostat.switchOff();
    }

    @Override
    public void setTempEverywhere(int temp) {
        thermostat.setTemp(temp);
    }

    @Override
    public void setVolumeEverywhere(int volume) {
        speaker.setVolume(volume);
    }

    @Override
    public void setMaxVolumeEverywhrere(int volume) {
        speaker.setMaxVolume(volume);
    }
}
