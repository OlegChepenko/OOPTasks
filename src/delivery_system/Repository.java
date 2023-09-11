package delivery_system;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

public class Repository {
    private ArrayList<Courier> couriers = new ArrayList<>();
    private ArrayList<Order> orders = new ArrayList<>();
    private Strategy strategy;

    public Repository(Strategy strategy) {
        this.strategy = strategy;
    }

    public void fillCouriers(){
        GeoCoordinate coordinate = new GeoCoordinate(10.0, 20.0);
        GeoCoordinate coordinate1 = new GeoCoordinate(20.0, 30.0);
        GeoCoordinate coordinate2 = new GeoCoordinate(30.0, 40.0);

        Courier courier1 = new Courier("Хуршид", "89035555551",40, coordinate );
        Courier courier2 = new Courier("Самандар", "89035555552",30, coordinate1 );
        Courier courier3 = new Courier("Джабут", "89035555553",20, coordinate2 );
        couriers.add(courier1);
        couriers.add(courier2);
        couriers.add(courier3);
    }
    public int getNumber(){
       Optional<Order> maxNumberOrder = orders.stream().max(Comparator.comparingInt(Order::getNumber));
       if (maxNumberOrder.isPresent()){
           return maxNumberOrder.get().getNumber()+1;
       }
       return 1;
    }

    public Order addOrder(int weight, GeoCoordinate source, GeoCoordinate destination) {
        int number = getNumber();
        Order order = new Order(weight, source, destination);
        order.setNumber(number);
        orders.add(order);
        return order;
    }
    public boolean assignCourier(Order order){

       Courier courier = strategy.findCourier(couriers, order);
       if(courier != null){
           courier.setAvailable(false);
           courier.addOrder(order);
           order.setCourier(courier);
           order.setStartDelivery(LocalDateTime.now());
           return true;
       }else return false;

    }

    public void completeOrder(Order order){
        order.setFinishDelivery(LocalDateTime.now());
        order.getCourier().setAvailable(true);
    }

}

//if (order.getWeight() <= courier.getMaxWeight() && courier.isAvailable()){
//        order.setCourier(courier);
//        courier.setAvailable(false);
//        }
