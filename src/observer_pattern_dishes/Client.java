package observer_pattern_dishes;

public class Client implements Subscriber{

    @Override
    public void orderReady(Order order) {
        System.out.println("Смс: Ваш заказ № " + order.getOrderNumber() + " готов");
    }
}
