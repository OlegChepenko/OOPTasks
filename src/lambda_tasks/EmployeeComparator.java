package lambda_tasks;

//    2. Создайте класс Employee, который имеет поля name, salary и age.
//    Реализуйте интерфейс Comparable для сравнения объектов Employee сначала по зарплате,
//    а затем по возрасту. Создайте несколько объектов Employee и отсортируйте их с использованием метода sort класса Arrays.
//
public class EmployeeComparator implements Comparable<EmployeeComparator> {
 private String name;
 private int salary;
 private int age;

    public EmployeeComparator(String name, int salary, int age) {
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public int compareTo(EmployeeComparator o) {
       int a =  Integer.compare(this.getSalary(), o.getSalary());
       return a == 0 ? Integer.compare(this.age, o.getAge()) : a;
    }
    @Override
    public String toString(){
        return String.format("Имя: %s, Зарплата %d, Возраст %d ", name, salary, age);
    }
}
