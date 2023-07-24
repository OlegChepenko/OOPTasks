package delivery_system;

import java.time.LocalDateTime;

public class Order {
    private int number;
    private int weight;
    private LocalDateTime startDelivery;
    private LocalDateTime finishDelivery;
    private GeoCoordinate startPoint;
    private GeoCoordinate finishPoint;
    private Courier courier;

    
}
