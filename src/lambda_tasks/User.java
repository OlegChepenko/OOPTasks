package lambda_tasks;

import java.util.Comparator;

public class User /*implements Comparable<User>*/ {
    private String name;
    private int age;


    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

 /*   @Override
    public int compareTo(User o) {
//        if (this.age == o.getAge()) return 0;
//        return this.age > o.getAge() ? 1 : -1;
        return Integer.compare(this.age, o.getAge());
    }

  */


}
