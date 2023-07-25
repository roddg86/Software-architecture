package ModelElements;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Scene {
    public int id;
    public ArrayList<PoligonalModel> models = new ArrayList<>();
    public ArrayList<Flash> flashes = new ArrayList<>();

    public Object method1(Object in1) {
        return in1;
    }

    public Object method2(Object in1, Object in2) {
        Object ret = new Object();
        return ret;
    }
}
