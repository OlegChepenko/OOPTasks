package student_task;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Student create() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите имя");
        String name = scanner.next();

        System.out.println("Введите фамилию");
        String surname = scanner.next();

        System.out.println("Введите группу");
        int group = scanner.nextInt();

        //вводим оценки
        Student student = new Student(name, surname, group, null);
        return student;
    }

    //функция вывода на экран
    //функция сортировки по средней оценки
    //функция поиска хороших студентов (возвращает новый список студентов)

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.print("n = ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {

        }
    }
}
