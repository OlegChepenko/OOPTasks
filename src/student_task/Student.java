package student_task;

import java.util.ArrayList;

public class Student {
    private String name;
    private String surname;
    private int group;
    private ArrayList<Mark> marks;


    public Student(String name, String surname, int group, ArrayList<Mark> marks) {
        this.name = name;
        this.surname = surname;
        this.group = group;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getGroup() {
        return group;
    }

    public ArrayList<Mark> getMarks() {
        return marks;
    }

    public double calcAverage() {
        int sum = 0;
        for (int i = 0; i < marks.size(); i++) {
            sum += marks.get(i).getMarkValue();
        }
        return (double) sum / marks.size();
    }

    public boolean checkGood() {
        for (int i = 0; i < marks.size(); i++) {
            if (marks.get(i).getMarkValue() < 4)
                return false;
        }
        return true;
    }
    public String marksString(){
        String s = "";
        for (Mark mark : marks) {
            s += mark.getMarkValue() + " ";
        }
        return s;
    }
}
