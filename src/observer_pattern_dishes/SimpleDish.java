package observer_pattern_dishes;

public class SimpleDish extends BaseDish{

    private boolean ready;

    public SimpleDish(String name, int cost) {
        super(name, cost);
    }

    @Override
    public boolean isReady() {
        return ready;
    }

    public void MarkIsReady(){
        ready = true;
    }

}
