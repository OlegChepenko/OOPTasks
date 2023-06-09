package the_future_is_electric_cars;
//Условие:
//Современный мир отказывается от двигателей внутреннего сгорания, и эра электрокаров не за горами. Нужно, чтобы наша программа могла отфильтровать электрокары от всех остальных автомобилей.
//        Для этих целей есть метод onlyElectricCars(ArrayList<Car>), который фильтрует список автомобилей, получаемых в качестве входящего параметра. Этот метод возвращает поток отфильтрованных данных, а именно — поток автомобилей, у которых поле isElectric равно true. В этом тебе поможет метод filter() объекта типа Stream<Car>.
//
//        Метод main() не принимает участие в тестировании.
//
//        Требования:
//        •	В публичном статическом методе onlyElectricCars(ArrayList<Car>) нужно вызывать метод filter() объекта типа Stream<Car>.
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Stream;

public class Main_the_future_is_electric_cars {
    public static void main(String[] args) {
        var cars = new ArrayList<Car>();
        Collections.addAll(cars,
                new Car("Range Rover", false),
                new Car("Model S", true),
                new Car("Navigator", false),
                new Car("Model 3", true),
                new Car("Camaro", false),
                new Car("Escalade", false),
                new Car("Mustang", false),
                new Car("Model X", true),
                new Car("X5", false),
                new Car("Model Y", true));

        var carStream = onlyElectricCars(cars);
        carStream.forEach(System.out::println);
    }

    public static Stream<Car> onlyElectricCars(ArrayList<Car> cars) {
        //напишите тут ваш код
        //Stream<Car> carStream = cars.stream().filter(s->s.isElectric());
        Stream<Car> carStream = cars.stream().filter(Car::isElectric);
        return carStream;
    }
}
