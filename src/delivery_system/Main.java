package delivery_system;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GeoCoordinate coordinate1 = new GeoCoordinate(2,3);
        GeoCoordinate coordinate2 = new GeoCoordinate(5,7);
        System.out.println("Какую стратегию использовать?");
        System.out.println("1. Ближайшее расстояние от заказа до курьера");
        System.out.println("2. Курьер у которого меньше всего заказов");
        Scanner scanner = new Scanner(System.in);
        int userChoice = scanner.nextInt();
        Strategy strategy;
        if (userChoice == 1){
            strategy = new MinimalDistanceStrategy();
        } else {
            strategy = new MinimalCountStrategy();
        }
        Repository repository = new Repository(strategy);
        repository.fillCouriers();
        Order order = repository.addOrder(15, coordinate1, coordinate2);
        repository.assignCourier(order);
        System.out.println(order.getCourier().getName());

       // double d1 = coordinate1.getDistanceTo(coordinate2);
      // double d2 = GeoCoordinate.getDistanceTo(coordinate1, coordinate2);


    }
}
