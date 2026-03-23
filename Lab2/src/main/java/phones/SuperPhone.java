package phones;

import cameras.*;

import java.util.List;

public class SuperPhone implements IPhone, Phone {


    //być może nie aż tak potrzebny stan telefonu
    private final PhoneCamerasManager camerasManager;

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
        if (batteryPercentage > 8) {
            //Sprawdzanie czy numer jest poprawny
            if(checkPhoneNumber(number)) {
                System.out.println("Dzwonię do: " + number);
                batteryPercentage -= 8;
            }
        } else {
            System.out.println("BŁĄD: Bateria jest za słaba, aby dzwonić!");
        }
    }

    @Override
    public void sendSms(String number, String message) {
        if (batteryPercentage > 5) {
            //Copy paste kodu z wyżej
            //nie ma co sie produkować za dużo
            if (checkPhoneNumber(number)) {
                System.out.println("Wysyłam SMS do " + number + ": " + message);
                batteryPercentage -= 5;
            }
        } else {
            System.out.println("BŁĄD: Bateria jest za słaba, aby wysłać SMS!");
        }
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
    public void chargeWithPin(){
        batteryPercentage += 10;
    }

    @Override
    public int getBattery() {
        return batteryPercentage;
    }

    @Override
    public void setBattery(int battery) {
        batteryPercentage = battery;
    }


}