package delivery_system;

import java.util.ArrayList;
import java.util.List;

public class Courier {
    private String name;
    private String phone;
    private int maxWeight;
    private boolean isAvailable;
    private GeoCoordinate location;
    private List<Order> orders;


    public Courier(String name, String phone, int maxWeight, GeoCoordinate location) {
        this.name = name;
        this.phone = phone;
        this.maxWeight = maxWeight;
        this.location = location;
        isAvailable = true;
        orders = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public GeoCoordinate getLocation() {
        return location;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
