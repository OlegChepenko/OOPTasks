package student_task;

public class Student {
    private String name;
    private String surname;
    private int group;
    private int[] marks;


    public Student(String name, String surname, int group, int[] marks) {
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

    public int[] getMarks() {
        return marks;
    }

    public double calcAverage() {
        int sum = 0;
        for (int i = 0; i < marks.length; i++) {
            sum += marks[i];
        }
        return (double) sum / marks.length;
    }

    public boolean checkGood() {
        for (int i = 0; i < marks.length; i++) {
            if (marks[i] < 4)
                return false;
        }
        return true;
    }
    public String marksString(){
        String s = "";
        for (int mark : marks) {
            s += mark + " ";
        }
        return s;
    }
}
