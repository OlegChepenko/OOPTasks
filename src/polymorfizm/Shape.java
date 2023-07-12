package polymorfizm;

public abstract class Shape {
    private int x;
    private int y;

    public Shape(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public abstract double calcArea();

    public void show() {
        System.out.println("X = " + x + ", Y = " + y);
    }
}
