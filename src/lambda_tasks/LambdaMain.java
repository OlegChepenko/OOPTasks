package lambda_tasks;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class LambdaMain {
    public static void main(String[] args) {
        Solution solution = new Solution();

        List<String> strings = Arrays.asList("apple", "banana", "cat", "dog");
        strings = solution.upperCase(strings);
//        strings.stream().forEach(System.out::println);


//        System.out.println( listSum(Arrays.asList(1,2,3,4,5)));
        List<String> strings5 = Arrays.asList("apple", "banana", "cat", "dog", "elephant");
        List<String> strings6 = solution.wordsMoreThenFive(strings);
        for (String s : strings6) {
//          System.out.println(s);
        }
        User user1 = new User("Tom", 50);
        User user2 = new User("Jack", 40);
        User user3 = new User("Jack", 50);
        User user4 = new User("Tom", 40);
//        user1.compareTo(user2);
        TreeSet<User> set = new TreeSet<>(new ComparatorUserNames().thenComparing(new ComparatorUserAge()));
        set.add(user1);
        set.add(user2);
        set.add(user3);
        set.add(user4);
        for (User u : set) {
            System.out.println(u.getName() + " " + u.getAge());
        }

        List<EmployeeComparator> employeeComparator = Arrays.asList(
                new EmployeeComparator("Ivan", 100000, 48),
                new EmployeeComparator("Petr", 50000, 35),
                new EmployeeComparator("Varvara", 30000, 25),
                new EmployeeComparator("Tom", 50000, 50));
                employeeComparator.sort(EmployeeComparator::compareTo);
                employeeComparator.forEach(System.out::println);
    }

    public static Integer listSum(List<Integer> list) {
        IOneParametr<List<Integer>, Integer> sum = l -> l.stream().mapToInt(i -> i).sum();
        return sum.start(list);
    }


}
