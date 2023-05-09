package workers;
// Дана ведомость расчета заработной платы (файл "data/workers").
// Рассчитайте зарплату всех работников, зная что они получат полный оклад,
// если отработают норму часов. Если же они отработали меньше нормы,
// то их ЗП уменьшается пропорционально, а за каждый час переработки они получают
// удвоенную ЗП, пропорциональную норме. // значит время разбить на штатное и переработку
// Кол-во часов, которые были отработаны, указаны в файле "data/hours_of"

public class Worker {
    private String name;
    private String surname;
    private String position;
    private int hoursNorm;
    private int hoursFact;
//    private int hoursExcessFact;
    private int salary;

    private int resultSalary = getResultSalary();

    public Worker(String name, String surname, int salary, String position, int hoursNorm) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.position = position;
        this.hoursNorm = hoursNorm;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPosition() {
        return position;
    }

    public int getHoursNorm() {
        return hoursNorm;
    }

    public int getSalary() {
        return salary;
    }

    public int getResultSalary() { return resultSalary;}

    public void setHoursFact(int hoursFact) {
        this.hoursFact = hoursFact;
    }

    public void resultSalary(){
//вычислить цену 1 часа оклада
        int oneHourCost = salary/hoursNorm;;
//вычислить цену 1 часа переработки
        int oneHourExcessCost = oneHourCost*2;
//количество часов переработки
        int hoursExcess = hoursFact - hoursNorm;
//Расчет зарплаты
        if (hoursExcess > 0){
            resultSalary = hoursExcess * oneHourExcessCost + hoursNorm * oneHourCost;
        } else {
            resultSalary = hoursFact * oneHourCost;
        }
    }
}

