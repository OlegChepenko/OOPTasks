package observer_pattern_dishes;

public abstract class BaseDish {
    private  String name;
    private int cost;

    public BaseDish(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public abstract boolean isReady();
}
