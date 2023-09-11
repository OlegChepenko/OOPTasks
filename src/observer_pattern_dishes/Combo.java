package observer_pattern_dishes;

import java.util.ArrayList;
import java.util.List;

public class Combo extends BaseDish{
    private List<SimpleDish> simpleDishes;

    public Combo(String name, int cost) {
        super(name, cost);
        simpleDishes = new ArrayList<>();
    }

    @Override
    public boolean isReady() {
        return simpleDishes
                .stream()
                .allMatch(t -> t.isReady());

    }

    public List<SimpleDish> getSimpleDishes() {
        return simpleDishes;
    }

    public void addSimpleDish(SimpleDish simpleDish){
        simpleDishes.add(simpleDish);
    }

}
