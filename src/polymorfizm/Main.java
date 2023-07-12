package polymorfizm;

public class Main {
    public static void main(String[] args) {
        Picture picture = new Picture();

        Circle circle = new Circle(2,3,10);
        Rectangle rectangle = new Rectangle(5,5,20,30);
        picture.add(circle);
        picture.add(rectangle);

        double area = picture.calcArea();
        System.out.println(area);

        picture.show();
    }
}
