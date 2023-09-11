package student_task;
//09.05.2023
//создать n студентов, отсортировать их по среднему баллу,
// и вывести всех хороших, у кого оценки 4,5

import com.bethecoder.ascii_table.ASCIITable;

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
        scanner.nextLine();
//вводим оценки
        ArrayList <Mark> marks = new ArrayList<>();
        int n = 1;
        while (n != 2) {
            System.out.println("Введите предмет: ");
            String subject = scanner.nextLine();
            System.out.println("Введите оценку по этому предмету: ");
            int markValue = scanner.nextInt();
            scanner.nextLine();
            Mark mark = new Mark(subject, markValue);
            marks.add(mark);
            System.out.println("Вы хотите продолжить вводить предметы и оценки? 1.Да, 2.Нет");
            n = scanner.nextInt();
            scanner.nextLine();
        }
        Student student = new Student(name, surname, group, marks);

        return student;
    }

    //функция сортировки по средней оценке
    static void sortStudents(ArrayList<Student> students) {
        for (int i = 0; i < students.size() - 1; i++) {
            for (int j = 0; j < students.size() - i - 1; j++) {
                Student tmp;
                double d = students.get(j).calcAverage();
                double d1 = students.get(j + 1).calcAverage();
                if (d > d1) {
                    tmp = students.get(j);
                    students.set(j, students.get(j + 1));
                    students.set(j + 1, tmp);
                }
            }
        }
    }

    //функция вывода на экран
    static void print(ArrayList<Student> students) {
        String[] tableHeaders = {"Имя", "Фамилия", "Группа", "Оценки", "Средняя оценка"};
        String[][] tableData = new String[students.size()][tableHeaders.length];
        for (int i = 0; i < students.size(); i++) {
            tableData[i][0] = students.get(i).getName();
            tableData[i][1] = students.get(i).getSurname();
            tableData[i][2] = String.valueOf(students.get(i).getGroup());
            tableData[i][3] = students.get(i).marksString();
            tableData[i][4] = String.valueOf(students.get(i).calcAverage());
        }
        ASCIITable.getInstance().printTable(tableHeaders, tableData);
    }

    //функция поиска хороших студентов (возвращает новый список студентов)
    static ArrayList<Student> findGoodStudents(ArrayList<Student> students) {
        ArrayList<Student> goodStudents = new ArrayList<>();
        for (int i = students.size() - 1; i >= 0; i--) {
            if (students.get(i).checkGood()){
                goodStudents.add(students.get(i));
            }
        }
        return goodStudents;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.print("n = ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            students.add(i, create());
        }
        sortStudents(students);
        ArrayList<Student> goodStudents = findGoodStudents(students);
        print(goodStudents);
    }
}
