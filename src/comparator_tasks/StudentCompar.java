package comparator_tasks;

//    4. Создайте класс Student, который имеет поля name, grade и age. Создайте класс StudentComparator,
//    который реализует интерфейс Comparator и сравнивает объекты Student сначала по классу в котором они учатся, а затем по возрасту.
//    Создайте несколько объектов Student
//    и отсортируйте их с использованием метода sort класса Arrays и передавая объект StudentComparator в качестве аргумента.

public class StudentCompar {
    private String name;
    private int grade;
    private int age;

    public StudentCompar(String name, int grade, int age) {
        this.name = name;
        this.grade = grade;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "StudentCompar{" +
                "name='" + name + '\'' +
                ", grade=" + grade +
                ", age=" + age +
                '}';
    }
}
