package device.decorator.device;


// żeby nie powtarzać kodu i zabezpieczyć się przed pomyłkami...
public interface ISleepModeBehaviour {

    int getHour();
    void setHour(int newHour);

    default boolean isSleepTimeNow() {
        return getHour() < 6 || getHour() > 22;
    }
}
