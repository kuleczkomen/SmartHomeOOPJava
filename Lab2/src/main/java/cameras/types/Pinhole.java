package cameras.types;

import cameras.PhoneCamerasManager;
import cameras.WideAngleCamera;

public class Pinhole implements CameraType{
    @Override
    public void setCamera(PhoneCamerasManager manager) {
        manager.setFrontCamera(null);
        manager.setBackCamera(null);
        manager.setWideAngleCamera(new WideAngleCamera());
        manager.setActiveCamera("PINHOLE");
    }
}
