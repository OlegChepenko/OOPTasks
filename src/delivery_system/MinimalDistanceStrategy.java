package delivery_system;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class MinimalDistanceStrategy implements Strategy {
//ищем ближайшего курьера
    @Override
    public Courier findCourier(List<Courier> couriers, Order order) {
        Optional<Courier> optionalCourier = couriers.stream()
                .filter(t -> t.isAvailable() && t.getMaxWeight() > order.getWeight())
                .sorted(new Comparator<Courier>() {
                    @Override
                    public int compare(Courier o1, Courier o2) {
                        double d1 = o1.getLocation().getDistanceTo(order.getStartPoint());
                        double d2 = o2.getLocation().getDistanceTo(order.getStartPoint());
//                       if (d1 > d2){
//                           return 1;
//                       }else if (d2 > d1){
//                           return -1;
//                       } else { return 0;}

                        return Double.compare(d1,d2);
                    }
                })
                .findFirst();

        if (optionalCourier.isPresent()){
            return optionalCourier.get();
        }else return null;
    }
}
