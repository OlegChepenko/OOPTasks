package salary_System;

public class Freelancer extends Employee {
    private int costHour;
    private int hours;

    public Freelancer(String fullName, int costHour, int hours) {
        super(0, 0, fullName);
        this.costHour = costHour;
        this.hours = hours;
    }

    @Override
    public int calcSalary() {
        return costHour * hours;
    }
}
