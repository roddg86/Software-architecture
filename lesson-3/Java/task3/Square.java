package task3;

public class Square implements Figure {
    private  int side;

    Square(int side){
        this.side = side;
    }
    @Override
    public int getArea() {
        return side * side;
    }
}
