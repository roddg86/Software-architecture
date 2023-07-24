package InMemoryModel;

import ModelElements.Camera;
import ModelElements.Flash;
import ModelElements.PoligonalModel;
import ModelElements.Scene;

public class ModelStore implements IModelChanger{
    public PoligonalModel Models;
    public Scene Scenes;

    public Flash Flashes;

    public Camera Cameras;
    private IModelChangedObserver changedObserver;

    public Scene GetScena(int id) {

        return null;
    }


    @Override
    public void NotifyChange(IModelChanger sender) {

    }


}
