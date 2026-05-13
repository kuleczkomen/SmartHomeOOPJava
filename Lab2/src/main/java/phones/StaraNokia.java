package phones;

import cameras.FrontCamera;

//Moze i nie umie za dużo
//Ale się stara
public class StaraNokia implements IPhone {
    public int batteryState;
    private FrontCamera camera;

        public StaraNokia() {
            this.camera = new FrontCamera();
            this.batteryState = 3000;
        }

    @Override
    public void call(String number) {
        if (batteryState > 100){
            System.out.println("Dzwonię z niezniszczalnej Nokii do: " + number);
            batteryState -= 100;
        }
        else {
            System.out.println("Bateria jest za słaba, aby zadzwonić!");
        }
    }

    @Override
    public void sendSms(String number, String message) {
        if (batteryState > 50) {
            System.out.println("Wysyłam SMS do " + number + ": " + message);
            batteryState -= 50;
        } else {
            System.out.println("Bateria jest za słaba, aby wysłać SMS!");
        }
    }

    @Override
    public void takePhoto() {
        if (batteryState > 125){
            camera.makeSelfie(30, 50);
            batteryState -= 125;
        }
        else {
            System.out.println("Bateria jest za słaba, aby wysłać SMS!");
        }


    }

    @Override
    public void connectTo5G() {
        throw new UnsupportedOperationException("Błąd: 5G w 2000 roku? Zapomnij.");
    }

    @Override
    public void browseInternet() {
        throw new UnsupportedOperationException("Błąd: Brak przeglądarki internetowej.");
    }

    @Override
    public void backupPhotos() {
        throw new UnsupportedOperationException("XD no na pewno to zadziała tutaj");
    }

    @Override
    public void charge(String chargerType) {
        if (chargerType.equals("Pin")) {
            this.batteryState += 400;
        } else if (chargerType.equals("Thin-Pin")) {
            System.out.println("A tez nie wspieram");
        } else {
            System.out.println("Nieobsługiwana ładowarka!");
        }
    }
}