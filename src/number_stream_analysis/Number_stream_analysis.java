package number_stream_analysis;
/*
https://javarush.com/quests/lectures/questsyntaxpro.level18.lecture05
Программа анализирует поток чисел. Логика программы следующая:

Метод hasNegativeEvenNumbers(Stream<Integer>) возвращает true, если во входящем потоке есть хотя бы одно отрицательное четное число и false, если таких чисел нет. Для поиска чисел в потоке используй метод anyMatch() объекта типа Stream<Integer>.
Метод hasOnlyPositiveNumbers(Stream<Integer>) возвращает true, если во входящем потоке есть только положительные числа и false, если есть хотя бы одно отрицательное число. Для поиска чисел в потоке используй метод allMatch() объекта типа Stream<Integer>.
Метод hasOnlyNegativeNumbers(Stream<Integer>) возвращает true, если во входящем потоке есть только отрицательные числа и false, если есть хотя бы одно положительное число. Для поиска чисел в потоке используй метод noneMatch() объекта типа Stream<Integer>.
Метод main() не принимает участие в тестировании.

Требования:
Публичный статический метод hasNegativeEvenNumbers(Stream<Integer>) нужно реализовать согласно условию.
Публичный статический метод hasOnlyPositiveNumbers(Stream<Integer>) нужно реализовать согласно условию.
Публичный статический метод hasOnlyNegativeNumbers(Stream<Integer>) нужно реализовать согласно условию.
 */
import java.util.stream.Stream;

public class Number_stream_analysis {
    public static void main(String[] args) {
        String answerYes = "Yes";
        String answerNo = "No";

        Stream<Integer> stream1 = Stream.of(10, -22, 3, 12, -85, 0, 142);

        String answerNegativeEvenNumbers = hasNegativeEvenNumbers(stream1) ? answerYes : answerNo;
        System.out.println("Any negative even numbers in the stream? " + answerNegativeEvenNumbers);

        Stream<Integer> stream2 = Stream.of(10, 22, 3, 12, 85, 142);

        String answerOnlyPositiveNumbers = hasOnlyPositiveNumbers(stream2) ? answerYes : answerNo;
        System.out.println("Only positive numbers in the stream? " + answerOnlyPositiveNumbers);

        Stream<Integer> stream3 = Stream.of(-10, -22, -3, -12, -85, -142);

        String answerOnlyNegativeNumbers = hasOnlyNegativeNumbers(stream3) ? answerYes : answerNo;
        System.out.println("Only negative numbers in the stream? " + answerOnlyNegativeNumbers);
    }

    public static boolean hasNegativeEvenNumbers(Stream<Integer> stream) {
        return stream.anyMatch(i -> i < 0 && i % 2 == 0);
    }

    public static boolean hasOnlyPositiveNumbers(Stream<Integer> stream) {
        return stream.allMatch(i -> i > 0);
    }

    public static boolean hasOnlyNegativeNumbers(Stream<Integer> stream) {
        return stream.noneMatch(i -> i > 0);
    }
}
