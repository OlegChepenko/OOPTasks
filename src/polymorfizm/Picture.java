package polymorfizm;

import java.util.ArrayList;

public class Picture {
    private ArrayList<Shape> shapes = new ArrayList<>();

    public void add(Shape shape) {
        shapes.add(shape);
    }

    public double calcArea() {
        double area = 0;
        for(Shape shape : shapes) {
            area += shape.calcArea();
        }
        return area;
    }

    public void show() {
        for(Shape shape : shapes) {
            shape.show();
        }
    }
}
