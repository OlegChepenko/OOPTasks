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

    public Order(int weight, GeoCoordinate startPoint, GeoCoordinate finishPoint) {
        this.weight = weight;
        this.startPoint = startPoint;
        this.finishPoint = finishPoint;
    }

    public GeoCoordinate getStartPoint() {
        return startPoint;
    }

    public int getWeight() {
        return weight;
    }

    public Courier getCourier() {
        return courier;
    }

    public int getNumber() {
        return number;
    }

    public LocalDateTime getStartDelivery() {
        return startDelivery;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setStartDelivery(LocalDateTime startDelivery) {
        this.startDelivery = startDelivery;
    }

    public void setFinishDelivery(LocalDateTime finishDelivery) {
        this.finishDelivery = finishDelivery;
    }

    public void setCourier(Courier courier) {
        this.courier = courier;
    }

}
