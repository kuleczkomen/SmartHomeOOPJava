package place;

public interface IPlace {

    void switchOnEverything();
    void switchOffEverything();

    void switchOnAllSpeakers();
    void switchOnAllLights();
    void switchOnAllThermostats();

    void switchOffAllSpeakers();
    void switchOffAllLights();
    void switchOffAllThermostats();

    void setTempEverywhere(int temp);
    void setVolumeEverywhere(int volume);
    void setMaxVolumeEverywhrere(int volume);
}
