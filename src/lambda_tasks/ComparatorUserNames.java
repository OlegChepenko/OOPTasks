package lambda_tasks;

import lambda_tasks.User;

import java.util.Comparator;

public class ComparatorUserNames implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
//        return o1.compareTo(o2);
        return  o1.getName().compareTo(o2.getName());
    }
}
