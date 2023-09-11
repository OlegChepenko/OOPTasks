package delivery_system;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class MinimalCountStrategy implements Strategy {

    @Override
    public Courier findCourier(List<Courier> couriers, Order order) {
        Optional<Courier> optionalCourier = couriers.stream()
                .filter(t -> t.isAvailable() && t.getMaxWeight() > order.getWeight())
                .sorted(new Comparator<Courier>() {
                    @Override
                    public int compare(Courier o1, Courier o2) {
                       int d1 = o1.countOrdersToday();
                       int d2 = o2.countOrdersToday();
                       return Integer.compare(d1,d2);
                    }
                }).findFirst();
        if (optionalCourier.isPresent()){
            return optionalCourier.get();
        }else return null;
    }
}
