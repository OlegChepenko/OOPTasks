package observer_pattern_dishes;

import java.util.List;

public interface IKitchenOrder {
    public void makeMealReady(String name);
    public List<SimpleDish> getSimpleMeals();
}
