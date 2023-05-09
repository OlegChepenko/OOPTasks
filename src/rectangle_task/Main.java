package rectangle_task;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static void fillList(ArrayList<Rectangle> rectangles, int n) {
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            int w = random.nextInt(1,20);
            int h = random.nextInt(1,20);
            Rectangle rectangle = new Rectangle(w, h);
            rectangles.add(rectangle);
        }
    }

    static void printList(ArrayList<Rectangle> rectangles) {
        for(Rectangle rectangle : rectangles) {
            System.out.println("W = " + rectangle.getWidth() + ", H = " + rectangle.getHeight());
        }
    }
    static Rectangle findMax(ArrayList<Rectangle> rectangles){
        Rectangle max = rectangles.get(0);
        for (int i = 0; i < rectangles.size(); i++) {
            if (rectangles.get(i).calcArea() > max.calcArea()){
                max = rectangles.get(i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        System.out.println("Введите ширину");
//        int width = scanner.nextInt();
//
//        System.out.println("Введите высоту");
//        int height = scanner.nextInt();
//
//        rectangle_task.Rectangle rectangle = new rectangle_task.Rectangle(width, height);
//        int s = rectangle.calcArea();
//
//        System.out.println("Площадь = " + s);

        ArrayList<Rectangle> rectangles = new ArrayList<>();
        System.out.print("n = ");
        int n = scanner.nextInt();
        fillList(rectangles, n);
        printList(rectangles);
        Rectangle max = findMax(rectangles);
        System.out.println("Самый большой = " + max.getWidth() + ", " + max.getHeight());

    }
}