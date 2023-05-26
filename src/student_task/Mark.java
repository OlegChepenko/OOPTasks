package student_task;

public class Mark {
    private String subject;
    private int markValue;

    public Mark(String subject, int markValue) {
        this.subject = subject;
        this.markValue = markValue;
    }

    public String getSubject() {
        return subject;
    }

    public int getMarkValue() {
        return markValue;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setMarkValue(int markValue) {
        this.markValue = markValue;
    }
}
