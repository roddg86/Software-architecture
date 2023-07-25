package InMemoryModel;

import ModelElements.Camera;
import ModelElements.Flash;
import ModelElements.PoligonalModel;
import ModelElements.Scene;

import java.util.ArrayList;
import java.util.List;

public class ModelStore implements IModelChanger{
    private List<Scene> scenes;
    private List<PoligonalModel> models;
    private List<Flash> flashes;
    private List<Camera> cameras;
    private IModelChangedObserver changedObserver;

    public ModelStore() {
        scenes = new ArrayList<>();
        models = new ArrayList<>();
        flashes = new ArrayList<>();
        cameras = new ArrayList<>();
    }

    public Scene getScene(int id) {

        return null;
    }


    @Override
    public void notifyChange(IModelChanger sender) {

    }


}
