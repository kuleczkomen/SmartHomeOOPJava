package cameras;

import cameras.types.CameraType;
import phones.SuperPhone;

public class PhoneCamerasManager {

    private FrontCamera frontCamera;
    private WideAngleCamera wideAngleCamera;
    private BackCamera backCamera;
    private String activeCamera = "";
    private final SuperPhone phone;

    public PhoneCamerasManager(SuperPhone phone) {
        frontCamera = new FrontCamera();
        wideAngleCamera = new WideAngleCamera();
        backCamera = new BackCamera();
        this.phone = phone;
    }

    public void setCamera(CameraType cameraType) {
        cameraType.setCamera(this);
    }

    public void setActiveCamera(String camera) {
        activeCamera = camera;
    }

    public void takePhoto() {
        if (phone.getBattery() > 12) {
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
            phone.setBattery(phone.getBattery() - 12);
        } else {
            System.out.println("BŁĄD: Bateria jest za słaba, aby zrobić zdjęcie!");
        }
    }

    public void setFrontCamera(FrontCamera newCamera){
        frontCamera = newCamera;
    }

    public void setBackCamera(BackCamera newCamera){
        backCamera = newCamera;
    }

    public void setWideAngleCamera(WideAngleCamera newCamera){
        wideAngleCamera = newCamera;
    }
}
