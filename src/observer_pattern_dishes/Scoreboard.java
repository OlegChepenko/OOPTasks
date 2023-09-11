package observer_pattern_dishes;

public class Scoreboard implements Subscriber {

    @Override
    public void orderReady(Order order) {
        System.out.println(" Табло: Заказ " + order.getOrderNumber() + " готов ");
    }
}
