package workSpace;


public class Department implements Comparable<Department> {
    private final int id;
    private final int parent;
    private final String name;

    public Department(int id, int parent, String name) {
        this.id = id;
        this.parent = parent;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getParent() {
        return parent;
    }

    public String getName() {
        return name;
    }



    @Override
    public int compareTo(Department o) {
        return name.length()-o.getName().length();
    }
}
