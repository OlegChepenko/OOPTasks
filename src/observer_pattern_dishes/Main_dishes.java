package observer_pattern_dishes;

import java.util.List;

public class Main_dishes {
    public static void main(String[] args) {

        Order order = new Order("1");
        SimpleDish potato = new SimpleDish("Картошка", 50);
        SimpleDish burger = new SimpleDish("Бургер", 450);
        SimpleDish cola = new SimpleDish("Кола", 200);
        Combo combo = new Combo("Счастливый завтрак", 500);
        combo.addSimpleDish(potato);
        combo.addSimpleDish(burger);
        order.addMeal(combo);
        order.addMeal(cola);

        Client client = new Client();
        order.subscribe(client);
        Scoreboard scoreboard = new Scoreboard();
        order.subscribe(scoreboard);

        List<String> strings = order.getReceiptInfo();
        strings.stream().forEach(System.out::println);
        order.makeMealReady("Кола");
        order.makeMealReady("Картошка");
        order.makeMealReady("Бургер");
        System.out.println(order.isReady());





    }
}
