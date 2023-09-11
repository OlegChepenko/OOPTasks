package observer_pattern_dishes;

import java.util.List;

public interface IClientOrder {
 void addMeal(BaseDish baseDish);
 List<String> getReceiptInfo();
 public void onOrderReady();
}
