package salary_System;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Employee employee = new Employee(45000, 20000, "Иванов Марк");
        Freelancer freelancer = new Freelancer("Орлов Леонид", 2000, 50);
        Director director = new Director(50000, 40000, "Попов Петр");
        director.addProject(new Project("Разработка сайта", 400000));
        director.addProject(new Project("ИИ", 800000));

        ArrayList<Employee> employees = new ArrayList<>(Arrays.asList(employee, freelancer, director));
        for(Employee emp : employees) {
            System.out.println(emp.getFullName() + " " + emp.calcSalary());
        }

        int a = 13;
        char h = 'j';

        int b = a + h;
        String c = "fgg";

    }
}
