package observer_pattern_dishes;

//import observer_pattern.Subscriber;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Order implements IKitchenOrder,IClientOrder {
    private List<BaseDish> baseDishes;
    private String orderNumber;
    private boolean isReady;

//Этот класс будет выступать источником для паттерна "Наблюдатель"
//Поэтому создаем список подписчиков
    private List<Subscriber> subscribers = new ArrayList<>();


    public Order(String orderNumber) {
        baseDishes = new ArrayList<>();
        this.orderNumber = orderNumber;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public boolean isReady() {
        return isReady;
    }

    @Override
    public void addMeal(BaseDish baseDish) {
        baseDishes.add(baseDish);
    }

    @Override
    public List<String> getReceiptInfo() {
        List<String> strings = new ArrayList<>();
        for (BaseDish b: baseDishes) {
            String s = b.getName() + " - " + b.getCost() + "руб.";
            strings.add(s);
        }
        return strings;
    }

    @Override
    public void onOrderReady() {
        for (Subscriber subscriber : subscribers) {
            subscriber.orderReady(this);
        }
    }


    //этот метод - триггер для оповещения подписчиков
    @Override
    public void makeMealReady(String name) {
        Optional<SimpleDish> dish = getSimpleMeals()
                .stream()
                .filter(t -> t.getName().equals(name)&&t.isReady()==false) //ищет по имени блюдо которое не готово,
                .findFirst();
        if (dish.isPresent()){
            dish.get().MarkIsReady();//и ставит пометку, что оно готово
            if (getSimpleMeals()
                    .stream()
                    .allMatch(t -> t.isReady()==true)){ //проверяет, что если все блюда готовы, ставит флаг всего заказа в значение "Готово"
                isReady = true;
                onOrderReady();
            }
        }

    }

    //Добавляет из списка baseDishes элементы в список simplDishes.
    //Если блюдо изначально простое, просто добавит
    //Если блюдо сложное, добавит из него сразу все элементы, через метод из класса Combo
    @Override
    public List<SimpleDish> getSimpleMeals() {
        List<SimpleDish> simpleDishes = new ArrayList<>();
        for (BaseDish baseDish : baseDishes) {
            if (baseDish instanceof SimpleDish sd){
                simpleDishes.add(sd);
            } else if (baseDish instanceof Combo cd){
                simpleDishes.addAll(cd.getSimpleDishes());//пример как можно добавить в список другой список
            }
        }
        return simpleDishes;
    }

    public void subscribe(Subscriber subscriber){
        if (!subscribers.contains(subscriber)){
            subscribers.add(subscriber);
        }
    }


}
