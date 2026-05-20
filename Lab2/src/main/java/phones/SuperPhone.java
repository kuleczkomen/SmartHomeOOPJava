package phones;

import cameras.*;

import java.util.List;

public class SuperPhone implements IPhone, Phone {


    //być może nie aż tak potrzebny stan telefonu
    private final PhoneCamerasManager camerasManager;

    public int batterState; //w Miliamperogodzinach (Mah)

    public SuperPhone() {
        this.batterState = 5000; //domyślnie pełna bateria
        this.frontCamera = new FrontCamera();
        this.backCamera = new BackCamera();
        this.wideAngleCamera = new WideAngleCamera();
    //to w sumie dodalem na ostatnia chwile
    //jestem ciekaw co z tym zrobicie xD
    //warto wgl rozkminic czy to jak to zostalo zaimplementowane wgl ma sens
    //np. czy to telefon powinien wiedzieć ile jest ładowany? Czy jednak coś innego winno to wiedzieć?
    //public wedle zamyslu programisty (niezbyt rozgarnietego jak widac) jest dlatego ze baterie wyswietla sie na telefonie
    private int batteryPercentage;
    private GPS gps;

    public SuperPhone() {
        batteryPercentage = 100; //domyślnie pełna bateria
        // ustawianiem kamer zajmie się manager :)
        camerasManager = new PhoneCamerasManager(this);
    }

    // DRY
    private boolean checkPhoneNumber(String number) {
        if (number == null || !number.startsWith("+")) {
            System.out.println("BŁĄD: Numer musi zaczynać się od '+'!");
            return false;
        }

        if (number.startsWith("+48")) { //Czy to polski numer
            String digits = number.substring(3);
            if (digits.length() != 9) { //walidacja dla polskiego numeru
                System.out.println("BŁĄD: Polski numer musi mieć dokładnie 9 cyfr!");
                return false;
            }
        } else if (number.startsWith("+49")) { //Czy to niemiecki numer
            if (number.length() < 12 || number.length() > 15) { //Walidacja dla niemieckiego
                System.out.println("BŁĄD: Niemiecki numer musi mieć od 10 do 13 cyfr po kierunkowym!");
                return false;
            }
            if (number.charAt(3) == '0') {
                System.out.println("BŁĄD: Niemiecki numer nie może mieć zera po kodzie kraju!");
                return false;
            }
        } else {
            System.out.println("BŁĄD: Nieobsługiwany kraj!");
            return false;
        }
        return true;
    }

    //SEKCJA Z DZWONIENIEM I SMSAMI
    @Override
    public void call(String number) {
        if (batterState > 200) {
            //Sprawdzanie czy numer jest poprawny
            if(checkPhoneNumber(number)) {
                System.out.println("Dzwonię do: " + number);
                batteryPercentage -= 8;
            }

            System.out.println("Dzwonię do: " + number);
            batterState -= 200;
        } else {
            System.out.println("BŁĄD: Bateria jest za słaba, aby dzwonić!");
        }
    }

    @Override
    public void sendSms(String number, String message) {
        if (batterState > 100) {
            //Copy paste kodu z wyżej
            //nie ma co sie produkować za dużo
            if (checkPhoneNumber(number)) {
                System.out.println("Wysyłam SMS do " + number + ": " + message);
                batteryPercentage -= 5;
            }

            if (number.startsWith("+48")) {
                String digits = number.substring(3);
                if (digits.length() != 9) {
                    System.out.println("BŁĄD: Polski numer musi mieć dokładnie 9 cyfr!");
                    return;
                }
            } else if (number.startsWith("+49")) {
                if (number.length() < 12 || number.length() > 15) {
                    System.out.println("BŁĄD: Niemiecki numer musi mieć od 10 do 13 cyfr po kierunkowym!");
                    return;
                }
                if (number.charAt(3) == '0') {
                    System.out.println("BŁĄD: Niemiecki numer nie może mieć zera po kodzie kraju!");
                    return;
                }
            } else {
                System.out.println("BŁĄD: Nieobsługiwany kraj!");
                return;
            }

            System.out.println("Wysyłam SMS do " + number + ": " + message);
            batterState -= 100;
        } else {
            System.out.println("BŁĄD: Bateria jest za słaba, aby wysłać SMS!");
        }
    }

    //SEKCJA Z KAMERAMI
    public void setCamera(String type) throws IllegalArgumentException {
        if (type.equalsIgnoreCase("PRZEDNIA")) {
            this.frontCamera = new FrontCamera();
            this.backCamera = null;
            this.wideAngleCamera = null;
            this.activeCamera = "PRZEDNIA";
            return;
        } else if (type.equalsIgnoreCase("TYLNIA")) {
            this.backCamera = new BackCamera();
            this.frontCamera = null;
            this.wideAngleCamera = null;
            this.activeCamera = "TYLNIA";
            return;
        } else if (type.equalsIgnoreCase("SZEROKOKATNA")) {
            this.wideAngleCamera = new WideAngleCamera();
            this.frontCamera = null;
            this.backCamera = null;
            this.activeCamera = "SZEROKOKATNA";
            return;
        }

        throw new IllegalArgumentException("Nieznany typ kamery: " + type);
    }

    @Override
    public void takePhoto() {
        if (batterState > 500) {
            if (activeCamera.equals("PRZEDNIA") && frontCamera != null) {
                //tu sa wymiary w centymetrach (bo tak)
                frontCamera.makeSelfie(100, 30);
            } else if (activeCamera.equals("TYLNIA") && backCamera != null) {
                //a tu w pixelach
                backCamera.captureMoment(1920, 1080);
            } else if (activeCamera.equals("SZEROKOKATNA") && wideAngleCamera != null) {
                //a tu se wgl zrobil programista wlasny obiekt
                wideAngleCamera.performOperationCommonlyKnownAsMakingPhoto(new PhotoSize(1920, 1080));
            } else {
                System.out.println("BŁĄD KRYTYCZNY: Nie wybrano aparatu lub sprzęt nie jest zainicjalizowany!");
                return;
            }
            batterState -= 500;
        } else {
            System.out.println("BŁĄD: Bateria jest za słaba, aby zrobić zdjęcie!");
        }
    }

    @Override
    public void connectTo5G() {
        if (batterState > 300) {
            System.out.println("Połączono z siecią 5G.");
            batterState -= 300;
        } else {
            System.out.println("BŁĄD: Bateria jest za słaba, aby połączyć się z 5G!");
        }
    @Override
    public void chargeWithThinPin() {
        batteryPercentage += 5;
    }

    @Override
    public void connectToGPS(GPS gps) {
        this.gps = gps;
    }

    @Override
    public List<Double> getPhoneLocation() {
        return gps.getLocation();
    }


    @Override
    public void browseInternet() {
        if (batterState > 400) {
            System.out.println("Otwieram przeglądarkę...");
            batterState -= 400;
        } else {
            System.out.println("BŁĄD: Bateria jest za słaba, aby przeglądać internet!");
        }
    }

    @Override
    public void backupPhotos() {
        if (batterState > 800) {
            GoogleDriveStorage googleStorage = new GoogleDriveStorage();

            System.out.println("Przygotowuję backup...");
            googleStorage.uploadAllPhotos();
            batterState -= 800;
        } else {
            System.out.println("BŁĄD: Bateria jest za słaba, aby zrobić backup!");
        }
    public void chargeWithPin(){
        batteryPercentage += 10;
    }

    @Override
    public int getBattery() {
        return batteryPercentage;
    }

    @Override
    public void charge(String chargerType){
        if (chargerType.equals("Pin")) {
            this.batterState += 1000;
        } else if (chargerType.equals("Thin-Pin")) {
            this.batterState += 500;
        } else {
            System.out.println("Nieobsługiwana ładowarka!");
        }
    public void setBattery(int battery) {
        batteryPercentage = battery;
    }


}