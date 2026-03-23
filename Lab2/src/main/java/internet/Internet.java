package internet;

import drives.GoogleDriveStorage;
import phones.IPhone;

public class Internet {
    public void browseInternet(IPhone phone) {
        if (phone.getBattery() > 10) {
            System.out.println("Otwieram przeglądarkę...");
            phone.setBattery(phone.getBattery() - 10);
        } else {
            System.out.println("BŁĄD: Bateria jest za słaba, aby przeglądać internet!");
        }
    }

    public void backupPhotos(IPhone phone) {
        if (phone.getBattery() > 15) {
            GoogleDriveStorage googleStorage = new GoogleDriveStorage();

            System.out.println("Przygotowuję backup...");
            googleStorage.uploadAllPhotos();
            phone.setBattery(phone.getBattery() - 15);
        } else {
            System.out.println("BŁĄD: Bateria jest za słaba, aby zrobić backup!");
        }
    }

    public void connectTo5G(IPhone phone) {
        if (phone.getBattery() > 6) {
            System.out.println("Połączono z siecią 5G.");
            phone.setBattery(phone.getBattery() - 6);
        } else {
            System.out.println("BŁĄD: Bateria jest za słaba, aby połączyć się z 5G!");
        }
    }
}
