package comparator_tasks;
// 3. Создайте класс Circle, который имеет поля radius и color.
//    Реализуйте интерфейс Comparable для сравнения объектов Circle по радиусу.
//    Создайте несколько объектов Circle и отсортируйте их с использованием метода sort класса Arrays.
public class Circle implements Comparable<Circle>{

    private int radius;
    private String color;

    public Circle(int radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public int compareTo(Circle o) {
        return Integer.compare(this.radius, o.radius);
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", color='" + color + '\'' +
                '}';
    }
}
