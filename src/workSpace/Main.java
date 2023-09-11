package workSpace;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static workSpace.Position.CHEF;

public class Main {
    private static List<Employee> emps = List.of(
            new Employee("Michael", "Smith",   243,  43, CHEF),
            new Employee("Jane",    "Smith",   523,  40, Position.MANAGER),
            new Employee("Jury",    "Gagarin", 6423, 26, Position.MANAGER),
            new Employee("Jack",    "London",  5543, 53, Position.WORKER),
            new Employee("Eric",    "Jackson", 2534, 22, Position.WORKER),
            new Employee("Andrew",  "Bosh",    3456, 44, Position.WORKER),
            new Employee("Joe",     "Smith",   723,  30, Position.MANAGER),
            new Employee("Jack",    "Gagarin", 7423, 35, Position.MANAGER),
            new Employee("Jane",    "London",  7543, 42, Position.WORKER),
            new Employee("Mike",    "Jackson", 7534, 31, Position.WORKER),
            new Employee("Jack",    "Bosh",    7456, 54, Position.WORKER),
            new Employee("Mark",    "Smith",   123,  41, Position.MANAGER),
            new Employee("Jane",    "Gagarin", 1423, 28, Position.MANAGER),
            new Employee("Sam",     "London",  1543, 52, Position.WORKER),
            new Employee("Jack",    "Jackson", 1534, 27, Position.WORKER),
            new Employee("Eric",    "Bosh",    1456, 32, Position.WORKER)
    );

    private static List<Department> deps = List.of(
            new Department(1, 0, "Head"),
            new Department(2, 1, "West"),
            new Department(3, 1, "East"),
            new Department(4, 2, "Germany"),
            new Department(5, 2, "France"),
            new Department(6, 3, "China"),
            new Department(7, 3, "Japan")
    );
    public static void main(String[] args) throws IOException {
        //CompareTo interface Comparable
//        if ( deps.get(0).compareTo(deps.get(1)) > 0) {
//            System.out.println("deps(0) больше");
//        } else if (deps.get(0).compareTo(deps.get(3)) == 0 ){
//            System.out.println("они равны");
//        } else System.out.println("deps(0) меньше");

// открывающие стрим методы
        Integer a = 1;
        Double b = 1.1;
        Stream<? extends Number> stream1 = Stream.of(a, b);
        int[] ints = {1,2,3,4};
        IntStream intStream = Arrays.stream(ints);
        IntStream streamInt = IntStream.of(1,2,3,4,5);
        Stream<String> stream = Files.lines(Path.of("numbers.txt"));
        //Builder статический метод
        Stream<String> stringStream = Stream.<String>builder().add("FirstElement").add("SecondElement").build();
        Stream<Employee> employeeStream = emps.stream();
        Stream<Employee> employeeStream1 = emps.parallelStream();
        AtomicInteger i = new AtomicInteger();
//        Stream.generate(() -> {
//            return i.getAndIncrement();
//        }).limit(20).forEach(System.out::println);
//        Stream.iterate(2000, (val) -> val+4).limit(10).forEach(System.out::println);
//        Stream.concat(stream,stringStream).forEach(System.out::println);


// промежуточные видоизменение
        Employee employee = emps.stream()
                .filter(e -> e.getAge() > 100)
                .findFirst()
                .orElse(new Employee("Ilya", "Ivanov", 508, 50, Position.WORKER));
//        System.out.println(employee);

//        emps.stream()
//                .map(e -> {
//                    int summ = e.getAge()+e.getId();
//                    return summ;
//                })
//                .forEach(System.out::println);
//        emps.stream()
//                .peek(e -> e.setPosition(Position.WORKER))
//                .forEach(System.out::println);

        //эта штука не получилась:
//        emps.stream()
//                .sorted().forEach(System.out::println);
//        emps.stream()
//                .sorted((e1,e2) -> e1.getAge()-e2.getAge())
//                .forEach(System.out::println);
//        emps.stream()
//                .sorted(Comparator.comparingInt(Employee::getAge).reversed())
//                .forEach(System.out::println);
        Stream<Employee> employeeStream2 = emps.stream()
                .takeWhile(e -> e.getAge() > 30);
       // printStream(employeeStream2);
        Stream<Employee> employeeStream3 = emps.stream()
                .dropWhile(e -> e.getAge() > 30);
       // printStream(employeeStream3);
        Stream<Employee> skip = emps.stream().skip(5);
       // printStream(skip);

// терминальные

//forEach
        //     streamInt.forEach(t -> System.out.println(t+1));

//        stream.forEach(new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                System.out.println(s);
//            }
//        });

        //   stream.forEach(t -> System.out.println(t));

//forEachOrdered - отрабатываются в разнобой

//Collector
//        List<Employee> collect = emps.stream().filter(e -> e.getAge() > 30).collect(Collectors.toList());
      /*  List<Employee> collect = emps.stream().filter(e -> e.getAge() > 30).toList();
        collect.forEach(System.out::println);

       */
//Coolector toMap
        Map<Integer, String> stringMap = emps.stream()
                .filter(e -> e.getAge() > 30)
                .collect(Collectors.toMap(
                        Employee::getId,
                        e -> String.format("%s %s", e.getFirstName(), e.getLastName())
                ));
       // System.out.println(stringMap);
//группа терминальных процедур простых типов: max,min,average,summaryStatistic,
//        System.out.println(IntStream.of(1,2,3,4,5).sum());
//        System.out.println(IntStream.of(1,2,3,4,5).max());
//        System.out.println(IntStream.of(1,2,3,4,5).min());
//        System.out.println(IntStream.of(1,2,3,4,5).average());
//        System.out.println(IntStream.of(1,2,3,4,5).summaryStatistics());
//anyMatch, allMatch, nonMatch
//        System.out.println(
//                emps
//                        .stream()
//                        .noneMatch(e -> e.getAge()>100)
//        );
//        System.out.println(
//                emps
//                        .stream()
//                        .anyMatch(e -> e.getAge()>100)
//        );
//        System.out.println(
//                emps
//                        .stream()
//                        .allMatch(e -> e.getAge()>100)
//        );

//min,max
//        Employee max = emps
//                .stream()
//                .max((e1, e2) -> e1.getAge() - e2.getAge()).get();
//        System.out.println(max);
//        Employee min = emps
//                .stream()
//                .min((e1, e2) -> e1.getAge() - e2.getAge()).get();
//        System.out.println(min);
//summarySatistic
//        IntSummaryStatistics intSummaryStatistics = emps
//                .stream()
//                .mapToInt(Employee::getAge)
//                .summaryStatistics();
//        System.out.println(intSummaryStatistics);



/*
* Составить цепочки стримов и сохранить их в переменные Stream, находящие:
1)Всех сотрудников старше сорока, отсортированных по убыванию, взять первых 4 человека.
2)Всех сотрудников младше 30 не являющихся шефом отсортированный по фамилии
* */
            Stream<Employee> stream2 = emps.stream().filter(e -> e.getAge()>40).limit(4);
            Stream<Employee> stream3 = emps.stream()
                    .filter(e -> e.getAge()<30 && e.getPosition() != CHEF)
                    .sorted(Comparator.comparing(Employee::getLastName));
        //    printStream(stream2);
        //    printStream(stream3);


    }
    public static void printStream(Stream<Employee> employeeStream){
        employeeStream
                .map(e -> {
                    String firstName = e.getFirstName();
                    String lastName = e.getLastName();
                    String id = String.valueOf(e.getId());
                    String age = String.valueOf(e.getAge());
                    String position = String.valueOf(e.getPosition());
                    return "Имя: " + firstName + " Фамилия: " + lastName + " Номер id: " + id + " Возраст: " + age
                            + " Должность: " + position;
                })
                .forEach(System.out::println);
    }


}