package comparator_tasks;
//    4. Создайте класс Student, который имеет поля name, grade и age. Создайте класс StudentComparator,
//    который реализует интерфейс Comparator и сравнивает объекты Student сначала по классу в котором они учатся, а затем по возрасту.
//    Создайте несколько объектов Student
//    и отсортируйте их с использованием метода sort класса Arrays и передавая объект StudentComparator в качестве аргумента.
import comparator_tasks.StudentCompar;

import java.util.Comparator;

public class StudentComparatorAge implements Comparator<StudentCompar> {
    @Override
    public int compare(StudentCompar o1, StudentCompar o2) {

        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
