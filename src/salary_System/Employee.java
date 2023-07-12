package salary_System;

public class Employee {
    private int oklad;
    private int premia;
    private String fullName;


    public Employee(int oklad, int premia, String fullName) {
        this.oklad = oklad;
        this.premia = premia;
        this.fullName = fullName;
    }

    public int calcSalary() {
        return oklad + premia;
    }

    public int getOklad() {
        return oklad;
    }

    public int getPremia() {
        return premia;
    }

    public String getFullName() {
        return fullName;
    }
}
