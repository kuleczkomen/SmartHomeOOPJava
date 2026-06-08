import cameras.PhoneCamerasManager;
import cameras.types.Sony;
import internet.Internet;
import phones.GPS;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== SMOKE TEST ===\n");

        // Test 1: StaraNokia - podstawowe operacje
        System.out.println("--- Test 1: StaraNokia ---");
        var oldPhone = new phones.StaraNokia();
        System.out.println("Bateria: " + oldPhone.batteryPercentage + "%");

        oldPhone.call("+48123456789");
        System.out.println("Bateria po rozmowie: " + oldPhone.batteryPercentage + "%");

        oldPhone.sendSms("+48123456789", "Hej!");
        System.out.println("Bateria po SMS: " + oldPhone.batteryState + "%");
        System.out.println("Bateria: " + oldPhone.getBattery() + "%");

        oldPhone.call("+48123456789");
        System.out.println("Bateria po rozmowie: " + oldPhone.getBattery() + "%");

        oldPhone.sendSms("+48123456789", "Hej!");
        System.out.println("Bateria po SMS: " + oldPhone.getBattery() + "%");

        // Próba wykonania nieobsługiwanej operacji
        // NIE DA SIĘ
//        try {
//            oldPhone.takePhoto();
//        } catch (UnsupportedOperationException e) {
//            System.out.println("Wyjątek: " + e.getMessage());
//        }

        // Ladowanie
        oldPhone.charge("Pin");
        System.out.println("Bateria po ladowaniu: " + oldPhone.batteryState + "%\n");
        oldPhone.chargeWithPin();
        System.out.println("Bateria po ladowaniu: " + oldPhone.getBattery() + "%\n");

        // Test 2: SuperPhone - podstawowe operacje
        System.out.println("--- Test 2: SuperPhone ---");
        var newPhone = new phones.SuperPhone();
        System.out.println("Bateria: " + newPhone.batteryPercentage + "%");

        newPhone.call("+49123456789012");
        System.out.println("Bateria po rozmowie: " + newPhone.batteryPercentage + "%");

        newPhone.sendSms("+48987654321", "Cześć SuperPhone!");
        System.out.println("Bateria po SMS: " + newPhone.batterState + "%");
        System.out.println("Bateria: " + newPhone.getBattery() + "%");

        newPhone.call("+49123456789012");
        System.out.println("Bateria po rozmowie: " + newPhone.getBattery() + "%");

        newPhone.sendSms("+48987654321", "Cześć SuperPhone!");
        System.out.println("Bateria po SMS: " + newPhone.getBattery() + "%");

        // Test 3: Zmiana aparatu i zrobienie zdjęcia
        System.out.println("\n--- Test 3: Aparaty ---");
        try {
            PhoneCamerasManager manager = new PhoneCamerasManager(newPhone);
            manager.setCamera(new Sony());
            System.out.println("Aktywna kamera: SONY");
            // takePhoto testuje wartość "PRZEDNIA", ale aparatu się nie zmienia prawidłowo
            manager.takePhoto();
        } catch (IllegalArgumentException e) {
            System.out.println("Błąd: " + e.getMessage());
        }
        System.out.println("Bateria po zdjeciu: " + newPhone.batteryPercentage + "%");

        // Test 4: Polaczenie 5G i przeglądanie internetu
        System.out.println("\n--- Test 4: Funkcje nowoczesne ---");
        newPhone.connectTo5G();
        System.out.println("Bateria po 5G: " + newPhone.batteryPercentage + "%");

        newPhone.browseInternet();
        System.out.println("Bateria po internecie: " + newPhone.batteryPercentage + "%");

        // Test 5: Backup (wykorzystuje GoogleDriveStorage)
        System.out.println("\n--- Test 5: Backup ---");
        newPhone.backupPhotos();
        System.out.println("Bateria po backupie: " + newPhone.batteryPercentage + "%");

        // Test 6: Testowanie limitu baterii
        System.out.println("\n--- Test 6: Limit baterii ---");
        System.out.println("Aktualna bateria: " + newPhone.batteryPercentage + "%");

        // Zuzywanie baterii
        while (newPhone.batteryPercentage > 5) {
            newPhone.connectTo5G();
            System.out.println("Bateria: " + newPhone.batterState + "%");
        System.out.println("Bateria po zdjeciu: " + newPhone.getBattery() + "%");

        // Test 4: Polaczenie 5G i przeglądanie internetu
        System.out.println("\n--- Test 4: Funkcje nowoczesne ---");
        Internet intenet = new Internet();
        intenet.connectTo5G(newPhone);
        System.out.println("Bateria po 5G: " + newPhone.getBattery() + "%");

        intenet.browseInternet(newPhone);
        System.out.println("Bateria po internecie: " + newPhone.
                getBattery() + "%");

        // Test 5: Backup (wykorzystuje GoogleDriveStorage)
        System.out.println("\n--- Test 5: Backup ---");
        intenet.backupPhotos(newPhone);
        System.out.println("Bateria po backupie: " + newPhone.getBattery() + "%");

        // Test 6: Testowanie limitu baterii
        System.out.println("\n--- Test 6: Limit baterii ---");
        System.out.println("Aktualna bateria: " + newPhone.getBattery() + "%");

        // Zuzywanie baterii
        while (newPhone.getBattery() > 5) {
            intenet.connectTo5G(newPhone);
            System.out.println("Bateria: " + newPhone.getBattery() + "%");
        }

        // Proba operacji be baterii
        System.out.println("Proba rozmowy bez baterii:");
        newPhone.call("+48123456789");

        // Ladowanie
        System.out.println("\nLadowanie SuperPhone...");
        newPhone.charge("Pin");
        System.out.println("Bateria: " + newPhone.batterState + "%");
        newPhone.chargeWithPin();
        System.out.println("Bateria: " + newPhone.getBattery() + "%");

        // Test 7: Bledny typ kamery
        System.out.println("\n--- Test 7: Bledny typ kamery ---");
        // NIE DA SIĘ
//        try {
//            PhoneCamerasManager manager = new PhoneCamerasManager(newPhone);
//            manager.setCamera("INVALID");
//        } catch (IllegalArgumentException e) {
//            System.out.println("Wyjątek: " + e.getMessage());
//        }

        System.out.println("\n--- Test 8: Łączymy się z GPS ---");
        newPhone.connectToGPS(new GPS());
        System.out.println(newPhone.getPhoneLocation());

        System.out.println("\n=== KONIEC SMOKE TESTU ===");
    }
}