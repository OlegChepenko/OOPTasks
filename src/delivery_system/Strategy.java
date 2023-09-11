package delivery_system;

import java.util.List;

public interface Strategy {
    Courier findCourier(List <Courier> couriers, Order order);
}
