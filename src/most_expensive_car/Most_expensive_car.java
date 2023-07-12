package most_expensive_car;
/*
Самый дорогой автомобиль
*
* Условия
* У автомобиля, представленного классом Car, есть две характеристики: название - поле name, цена - поле price.
В классе Solution выполняются две операции поиска:

метод getMostExpensiveCar(Stream<Car>) ищет самый дорогой автомобиль в одном списке;
метод getMoreExpensiveCar(Stream<Car>, Car) в другом списке ищет автомобиль дороже,
*  чем полученный в методе getMostExpensiveCar(Stream<Car>).
Методы возвращают не сам автомобиль (объект типа Car), а объект типа Optional<Car>.
Подсказка:
Для поиска элемента с максимальным искомым значением в потоке данных используй метод max(),
* а чтобы найти первый попавшийся подходящий элемент из потока отфильтрованных данных используй метод findFirst().
 */


import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class Most_expensive_car {
    public static void main(String[] args) {
        var tesla = Stream.of(
                new Car("Model S", 94_490),
                new Car("Model 3", 50_690),
                new Car("Model X", 99_690),
                new Car("Model Y", 65_000)
        );

        var bmw = Stream.of(
                new Car("X5", 110_000),
                new Car("X3", 54_000),
                new Car("X7", 143_000),
                new Car("X6", 125_000)
        );

        Optional<Car> mostExpensiveCar = getMostExpensiveCar(tesla);
        mostExpensiveCar.ifPresent(System.out::println);

        Optional<Car> moreExpensiveCar = mostExpensiveCar.flatMap(car -> getMoreExpensiveCar(bmw, car));
        moreExpensiveCar.ifPresent(System.out::println);
    }

    public static Optional<Car> getMostExpensiveCar(Stream<Car> cars) {
        //напишите тут ваш код
        Optional<Car> car = cars.max((s1,s2) -> s1.getPrice()- s2.getPrice());
        //Optional <Car> car = cars.max(Comparator.comparingInt(Car::getPrice));
        //return cars.max(Comparator.comparingInt(Car::getPrice));
        return car;
    }

    public static Optional<Car> getMoreExpensiveCar(Stream<Car> cars, Car mostExpensiveCar) {
        //напишите тут ваш код
        Optional<Car> car = cars.filter(s1-> s1.getPrice() > mostExpensiveCar.getPrice()).findFirst();
        return Optional.empty();
    }
}

class Car {
    private String name;
    private Integer price;

    public Car(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Автомобиль " + name + ", цена - " + price + " USD";
    }
}
