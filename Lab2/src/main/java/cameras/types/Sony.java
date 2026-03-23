package cameras.types;

import cameras.FrontCamera;
import cameras.PhoneCamerasManager;

public class Sony implements CameraType{
    @Override
    public void setCamera(PhoneCamerasManager manager) {
        manager.setFrontCamera(new FrontCamera());
        manager.setBackCamera(null);
        manager.setWideAngleCamera(null);
        manager.setActiveCamera("SONY");
    }
}
