package phones;

import java.util.List;

//Moze i nie umie za dużo
//Ale się stara
public class StaraNokia implements IPhone {
    public int batteryPercentage = 100;

    @Override
    public void call(String number) {
        if (batteryPercentage > 5){
            System.out.println("Dzwonię z niezniszczalnej Nokii do: " + number);
            batteryPercentage -= 5;
        }
        else {
            System.out.println("Bateria jest za słaba, aby zadzwonić!");
        }
    }

    @Override
    public void sendSms(String number, String message) {
        if (batteryPercentage > 3) {
            System.out.println("Wysyłam SMS do " + number + ": " + message);
            batteryPercentage -= 3;
        } else {
            System.out.println("Bateria jest za słaba, aby wysłać SMS!");
        }
    }

    @Override
    public void chargeWithThinPin() {

    }

    @Override
    public void connectToGPS(GPS gps) {

    }

    @Override
    public List<Double> getPhoneLocation() {
        return List.of();
    }

    public void takePhoto() {
        throw new UnsupportedOperationException("Błąd: Nokia 3310 nie ma aparatu!");
    }

    public void connectTo5G() {
        throw new UnsupportedOperationException("Błąd: 5G w 2000 roku? Zapomnij.");
    }

    public void browseInternet() {
        throw new UnsupportedOperationException("Błąd: Brak przeglądarki internetowej.");
    }

    public void backupPhotos() {
        throw new UnsupportedOperationException("XD no na pewno to zadziała tutaj");
    }

    public void charge(String chargerType) {
        if (chargerType.equals("Pin")) {
            this.batteryPercentage += 30;
        } else if (chargerType.equals("Thin-Pin")) {
            System.out.println("A tez nie wspieram");
        } else {
            System.out.println("Nieobsługiwana ładowarka!");
        }
    }

    public int getBattery() {
        return 0;
    }

    @Override
    public void setBattery(int battery) {

    }
}