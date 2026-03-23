package phones;

import cameras.FrontCamera;
import cameras.PhotoSize;
import cameras.WideAngleCamera;
import cameras.BackCamera;

public class SuperPhone implements IPhone {

    private FrontCamera frontCamera;
    private WideAngleCamera wideAngleCamera;
    private BackCamera backCamera;

    //być może nie aż tak potrzebny stan telefonu
    private String activeCamera = "none";

    //to w sumie dodalem na ostatnia chwile
    //jestem ciekaw co z tym zrobicie xD
    //warto wgl rozkminic czy to jak to zostalo zaimplementowane wgl ma sens
    //np. czy to telefon powinien wiedzieć ile jest ładowany? Czy jednak coś innego winno to wiedzieć?
    //public wedle zamyslu programisty (niezbyt rozgarnietego jak widac) jest dlatego ze baterie wyswietla sie na telefonie
    public int batteryPercentage;

    public SuperPhone() {
        this.batteryPercentage = 100; //domyślnie pełna bateria
        this.frontCamera = new FrontCamera();
        this.backCamera = new BackCamera();
        this.wideAngleCamera = new WideAngleCamera();
    }

    //SEKCJA Z DZWONIENIEM I SMSAMI
    @Override
    public void call(String number) {
        if (batteryPercentage > 8) {
            //Sprawdzanie czy numer jest poprawny
            if (number == null || !number.startsWith("+")) {
                System.out.println("BŁĄD: Numer musi zaczynać się od '+'!");
                return;
            }

            if (number.startsWith("+48")) { //Czy to polski numer
                String digits = number.substring(3);
                if (digits.length() != 9) { //walidacja dla polskiego numeru
                    System.out.println("BŁĄD: Polski numer musi mieć dokładnie 9 cyfr!");
                    return;
                }
            } else if (number.startsWith("+49")) { //Czy to niemiecki numer
                if (number.length() < 12 || number.length() > 15) { //Walidacja dla niemieckiego
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

            System.out.println("Dzwonię do: " + number);
            batteryPercentage -= 8;
        } else {
            System.out.println("BŁĄD: Bateria jest za słaba, aby dzwonić!");
        }
    }

    @Override
    public void sendSms(String number, String message) {
        if (batteryPercentage > 5) {
            //Copy paste kodu z wyżej
            //nie ma co sie produkować za dużo
            if (number == null || !number.startsWith("+")) {
                System.out.println("BŁĄD: Numer musi zaczynać się od '+'!");
                return;
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
            batteryPercentage -= 5;
        } else {
            System.out.println("BŁĄD: Bateria jest za słaba, aby wysłać SMS!");
        }
    }

    //SEKCJA Z KAMERAMI
    public void setCamera(String type) throws IllegalArgumentException {
        if (type.equalsIgnoreCase("SONY")) {
            this.frontCamera = new FrontCamera();
            this.backCamera = null;
            this.wideAngleCamera = null;
            this.activeCamera = "SONY";
            return;
        } else if (type.equalsIgnoreCase("SAMSUNG")) {
            this.backCamera = new BackCamera();
            this.frontCamera = null;
            this.wideAngleCamera = null;
            this.activeCamera = "SAMSUNG";
            return;
        } else if (type.equalsIgnoreCase("PINHOLE")) {
            this.wideAngleCamera = new WideAngleCamera();
            this.frontCamera = null;
            this.backCamera = null;
            this.activeCamera = "PINHOLE";
            return;
        }

        throw new IllegalArgumentException("Nieznany typ kamery: " + type);
    }

    @Override
    public void takePhoto() {
        if (batteryPercentage > 12) {
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
            batteryPercentage -= 12;
        } else {
            System.out.println("BŁĄD: Bateria jest za słaba, aby zrobić zdjęcie!");
        }
    }

    @Override
    public void connectTo5G() {
        if (batteryPercentage > 6) {
            System.out.println("Połączono z siecią 5G.");
            batteryPercentage -= 6;
        } else {
            System.out.println("BŁĄD: Bateria jest za słaba, aby połączyć się z 5G!");
        }
    }

    @Override
    public void browseInternet() {
        if (batteryPercentage > 10) {
            System.out.println("Otwieram przeglądarkę...");
            batteryPercentage -= 10;
        } else {
            System.out.println("BŁĄD: Bateria jest za słaba, aby przeglądać internet!");
        }
    }

    @Override
    public void backupPhotos() {
        if (batteryPercentage > 15) {
            GoogleDriveStorage googleStorage = new GoogleDriveStorage();

            System.out.println("Przygotowuję backup...");
            googleStorage.uploadAllPhotos();
            batteryPercentage -= 15;
        } else {
            System.out.println("BŁĄD: Bateria jest za słaba, aby zrobić backup!");
        }
    }
    @Override
    public void charge(String chargerType){
        if (chargerType.equals("Pin")) {
            this.batteryPercentage += 10;
        } else if (chargerType.equals("Thin-Pin")) {
            this.batteryPercentage += 5;
        } else {
            System.out.println("Nieobsługiwana ładowarka!");
        }
    }
}