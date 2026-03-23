package cameras.types;

import cameras.BackCamera;
import cameras.PhoneCamerasManager;

public class Samsung implements CameraType{
    @Override
    public void setCamera(PhoneCamerasManager manager) {
        manager.setBackCamera(new BackCamera());
        manager.setFrontCamera(null);
        manager.setWideAngleCamera(null);
        manager.setActiveCamera("SAMSUNG");
    }
}
