
public class Main {
    public static void main(String[] args) {
        System.out.println("=== SMOKE TEST ===\n");

        // Test 1: StaraNokia - podstawowe operacje
        System.out.println("--- Test 1: StaraNokia ---");
        var oldPhone = new phones.StaraNokia();
        System.out.println("Bateria: " + oldPhone.batteryState + "%");

        oldPhone.call("+48123456789");
        System.out.println("Bateria po rozmowie: " + oldPhone.batteryState + "%");

        oldPhone.sendSms("+48123456789", "Hej!");
        System.out.println("Bateria po SMS: " + oldPhone.batteryState + "%");

        // Próba wykonania nieobsługiwanej operacji
        try {
            oldPhone.takePhoto();
        } catch (UnsupportedOperationException e) {
            System.out.println("Wyjątek: " + e.getMessage());
        }

        // Ladowanie
        oldPhone.charge("Pin");
        System.out.println("Bateria po ladowaniu: " + oldPhone.batteryState + "%\n");

        // Test 2: SuperPhone - podstawowe operacje
        System.out.println("--- Test 2: SuperPhone ---");
        var newPhone = new phones.SuperPhone();
        System.out.println("Bateria: " + newPhone.batterState + "%");

        newPhone.call("+49123456789012");
        System.out.println("Bateria po rozmowie: " + newPhone.batterState + "%");

        newPhone.sendSms("+48987654321", "Cześć SuperPhone!");
        System.out.println("Bateria po SMS: " + newPhone.batterState + "%");

        // Test 3: Zmiana aparatu i zrobienie zdjęcia
        System.out.println("\n--- Test 3: Aparaty ---");
        try {
            newPhone.setCamera("SONY");
            System.out.println("Aktywna kamera: SONY");
            // takePhoto testuje wartość "PRZEDNIA", ale aparatu się nie zmienia prawidłowo
            newPhone.takePhoto();
        } catch (IllegalArgumentException e) {
            System.out.println("Błąd: " + e.getMessage());
        }
        System.out.println("Bateria po zdjeciu: " + newPhone.batterState + "%");

        // Test 4: Polaczenie 5G i przeglądanie internetu
        System.out.println("\n--- Test 4: Funkcje nowoczesne ---");
        newPhone.connectTo5G();
        System.out.println("Bateria po 5G: " + newPhone.batterState + "%");

        newPhone.browseInternet();
        System.out.println("Bateria po internecie: " + newPhone.batterState + "%");

        // Test 5: Backup (wykorzystuje GoogleDriveStorage)
        System.out.println("\n--- Test 5: Backup ---");
        newPhone.backupPhotos();
        System.out.println("Bateria po backupie: " + newPhone.batterState + "%");

        // Test 6: Testowanie limitu baterii
        System.out.println("\n--- Test 6: Limit baterii ---");
        System.out.println("Aktualna bateria: " + newPhone.batterState + "%");

        // Zuzywanie baterii
        while (newPhone.batterState > 5) {
            newPhone.connectTo5G();
            System.out.println("Bateria: " + newPhone.batterState + "%");
        }

        // Proba operacji be baterii
        System.out.println("Proba rozmowy bez baterii:");
        newPhone.call("+48123456789");

        // Ladowanie
        System.out.println("\nLadowanie SuperPhone...");
        newPhone.charge("Pin");
        System.out.println("Bateria: " + newPhone.batterState + "%");

        // Test 7: Bledny typ kamery
        System.out.println("\n--- Test 7: Bledny typ kamery ---");
        try {
            newPhone.setCamera("INVALID");
        } catch (IllegalArgumentException e) {
            System.out.println("Wyjątek: " + e.getMessage());
        }

        System.out.println("\n=== KONIEC SMOKE TESTU ===");
    }
}