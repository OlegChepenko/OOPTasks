package figure;

import java.util.Scanner;

public class MainFigure {
    public static void main(String[] args) {
        System.out.println("С какой фигурой вы хотите работать? 1. Треугольник, 2. Круг");
        Scanner scanner = new Scanner(System.in);
        int f = scanner.nextInt();
        Figure figure = null;
        switch (f) {
            case 1 -> {
                System.out.println("Введите сторону а: ");
                double a = scanner.nextDouble();
                System.out.println("Введите сторону b: ");
                double b = scanner.nextDouble();
                System.out.println("Введите сторону c: ");
                double c = scanner.nextDouble();
                figure = new Triangle(a, b, c);
            }
            // System.out.println(triangle.calcArea());
            case 2 -> {
                System.out.println("Введите радиус r: ");
                double r = scanner.nextDouble();
                figure = new Circl(r);
            }
            // System.out.println(circl.calcArea());
            default -> System.out.println(" Вы ввели не верное число ");
        }
        if (figure != null) {
            System.out.println(figure.calcArea());
        }

        //        if (f == 1) {
//            System.out.println("Введите сторону а: ");
//            double a = scanner.nextDouble();
//            System.out.println("Введите сторону b: ");
//            double b = scanner.nextDouble();
//            System.out.println("Введите сторону c: ");
//            double c = scanner.nextDouble();
//            Triangle triangle = new Triangle(a,b,c);
//            System.out.println(triangle.calcArea());
//        }
//        if (f == 2){
//            System.out.println("Введите радиус r: ");
//            double a = scanner.nextDouble();
//            Circl circl = new Circl(a);
//            System.out.println(circl.calcArea());
//        }
    }
}
