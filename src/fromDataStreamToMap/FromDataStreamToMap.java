package fromDataStreamToMap;
/*
Из потока данных — в map
Необходимо, чтобы метод getMap(Stream<String>) преобразовывал входящий поток строк в карту (map),
ключом которой является сама строка, а значением — её длина.
Реализуй его, используя метод collect() объекта типа Stream<String>.
В качестве параметра передай нужный коллектор (объект типа Collector<Map<String, Integer>>).
Такой объект можно получить, вызвав статический метод toMap() класса Collectors.
Метод main() не принимает участие в тестировании.
Требования:
•В публичном статическом методе getMap(Stream<String>) нужно вызывать статический метод toMap() класса Collectors.
•Метод getMap(Stream<String>) нужно реализовать согласно условию.
*/
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;
public class FromDataStreamToMap {
    public static void main(String[] args) {
        var stringStream = Stream.of("JavaRush", "CodeGym", "Amigo", "Elly", "Kim", "Risha");

        getMap(stringStream).forEach((s, i) -> System.out.println(s + " - " + i));
    }

    public static Map<String, Integer> getMap(Stream<String> stringStream) {
        //напишите тут ваш код
        return stringStream.collect(toMap(e->e, String::length));
    }
}
