package salary_System;

import java.util.ArrayList;

public class Director extends Employee {
    private ArrayList<Project> projects = new ArrayList<>();

    public Director(int oklad, int premia, String fullName) {
        super(oklad, premia, fullName);
    }

    public void addProject(Project project) {
        projects.add(project);
    }

    @Override
    public int calcSalary() {
        int salary = super.calcSalary();
        for(Project p : projects) {
            salary += p.getCost() * 0.01;
        }
        return salary;
    }
}
