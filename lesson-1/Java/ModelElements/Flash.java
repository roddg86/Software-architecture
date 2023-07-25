package ModelElements;


import Stuff.Angle3D;
import Stuff.Point3D;

public class Flash {
    public Point3D location;
    public Angle3D angle;
    public Color color;
    public Float power;

    public Flash(Point3D location, Angle3D angle, Color color, Float power) {
        this.location = location;
        this.angle = angle;
        this.color = color;
        this.power = power;
    }

    public void Move(Point3D location) {

    }

    public void Rotate(Angle3D angle) {

    }
}
