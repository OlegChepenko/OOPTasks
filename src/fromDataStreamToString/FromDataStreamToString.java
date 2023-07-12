package fromDataStreamToString;
/*
Необходимо, чтобы метод getString(Stream<String>) преобразовывал входящий поток строк в строку,
слова в которой нужно разделить пробелом. Порядок слов в строке должен соответствовать порядку элементов в потоке.
Реализуй его, используя метод collect() объекта типа Stream<String>.
В качестве параметра передай нужный коллектор (объект типа Collector<String>).
Такой объект можно получить, вызвав статический метод joining() класса Collectors.
Метод main() не принимает участие в тестировании.
Требования:
•В публичном статическом методе getString(Stream<String>) нужно вызывать статический метод joining() класса Collectors.
•Метод getString(Stream<String>) нужно реализовать согласно условию.*/
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static java.util.stream.Collectors.joining;
public class FromDataStreamToString {
    public static void main(String[] args) {
        var stringStream = Stream.of("To", "be", "a", "programmer", "you", "need", "to", "code");

        System.out.println(getString(stringStream));
    }

    public static String getString(Stream<String> stringStream) {
        //напишите тут ваш код

        return stringStream.collect(joining(" "));
    }
    //дополнительный пример перевода потока в строку:
    static void primer() {
        ArrayList<String> list = new ArrayList<String>();
        Collections.addAll(list, "a=2", "b=3", "c=4", "d==3");
        String result = list.stream().collect(Collectors.joining(", "));
    }
}
