package comparator_tasks;
//2023-09-02

//    2. Создайте класс Employee, который имеет поля name, salary и age.
//    Реализуйте интерфейс Comparable для сравнения объектов Employee сначала по зарплате,
//    а затем по возрасту. Создайте несколько объектов Employee и отсортируйте их с использованием метода sort класса Arrays.
//
//
//    3. Создайте класс Circle, который имеет поля radius и color.
//    Реализуйте интерфейс Comparable для сравнения объектов Circle по радиусу.
//    Создайте несколько объектов Circle и отсортируйте их с использованием метода sort класса Arrays.
//
//
//    4. Создайте класс Student, который имеет поля name, grade и age. Создайте класс StudentComparator,
//    который реализует интерфейс Comparator и сравнивает объекты Student сначала по классу в котором они учатся, а затем по возрасту.
//    Создайте несколько объектов Student
//    и отсортируйте их с использованием метода sort класса Arrays и передавая объект StudentComparator в качестве аргумента.

import lambda_tasks.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main_Comparator_tasks {
    public static void main(String[] args) {
        Circle circle = new Circle(5, "Red");
        Circle circle1 = new Circle(6, "Green");
        Circle circle2 = new Circle(2, "Blue");
        List<Circle> circles = new ArrayList<>();
        circles.add(circle);
        circles.add(circle1);
        circles.add(circle2);
        circles.sort(Circle::compareTo);
        circles.forEach(System.out::println);

        StudentCompar student = new StudentCompar("Ivanov", 1, 20);
        StudentCompar student1 = new StudentCompar("Petrov", 2, 25);
        StudentCompar student2 = new StudentCompar("Sidorov", 2, 23);
        StudentCompar[] students = new StudentCompar[]{student, student1, student2};
        Arrays.sort(students, new StudentComparatorGrade().thenComparing(new StudentComparatorAge()));
//        for (StudentCompar st : students) {
//            System.out.println(st);
//        }


    }

}
