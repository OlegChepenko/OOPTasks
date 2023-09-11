package lambda_tasks;

import java.util.*;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    //1. Функция сложения: Напишите лямбда-выражение, которое принимает два целых числа и возвращает их сумму.
    public double summ(double a, double b) {
        ITwoParametrs<Double> summ = (c, d) -> c + d;
        double d = summ.start(a, b);
        return d;
    }

    //2. Функция возведения в степень: Напишите лямбда-выражение, которое принимает вещественное число и степень,
// и возвращает результат возведения числа в данную степень.
    public double pow(double a, double b) {
//        ITwoParametrs<Double> pow = (c, d) -> Math.pow(c, d);
        ITwoParametrs<Double> pow = Math::pow;
        double d = pow.start(a, b);
        return d;
    }

    //3. Функция проверки четности: Напишите лямбда-выражение,
// которое принимает целое число и возвращает булево значение, указывающее, является ли число четным.
    public boolean chetNeChet(int a) {
        IOneParametr<Integer, Boolean> even = (e) -> e % 2 == 0;
        return even.start(4);
    }

    //4. Функция реверса строки: Напишите лямбда-выражение, которое принимает строку и возвращает ее в обратном порядке.
    public String reversString(String s) {
        IOneParametr<String, String> revers = s1 -> {
            StringBuilder s2 = new StringBuilder();
            for (int i = s1.length() - 1; i >= 0; i--) {
                s2.append(s1.charAt(i));
            }
            return s2.toString();
        };
        String newString = revers.start(s);
        return newString;
    }

    //5. Функция объединения строк: Напишите лямбда-выражение, которое принимает две строки и возвращает их объединение.
    public String concat(String s1, String s2) {
        ITwoParametrs<String> concat = (str1, str2) -> str1 + str2;
        return concat.start(s1, s2);
    }

    //6. Функция проверки наличия подстроки: Напишите лямбда-выражение, которое принимает две строки и возвращает булево значение,
// указывающее, содержится ли первая строка во второй.
    public boolean proverkaPodstroki(String s1, String s2) {
//        ITwoParamAndTwoTypes<String, Boolean> check = (str1, str2) -> {
//            return str1.contains(str2);
//        }
        ITwoParamAndTwoTypes<String, Boolean> check = String::contains;
        return check.start(s1, s2);

    }
//7. Функция сортировки списка объектов: Напишите лямбда-выражение, которое принимает список объектов и сортирует его
// по определенному свойству (например, по возрастанию или убыванию значения).(Компаратор)

//8. Функция фильтрации списка объектов: Напишите лямбда-выражение, которое принимает список объектов и возвращает новый список,
// содержащий только объекты, удовлетворяющие определенному условию.
//    public List<Object> filter1(List<Object> objects){
//        IOneParametr<Object> filter1 =
//    }


//9. Функция преобразования списка объектов: Напишите лямбда-выражение, которое принимает список объектов и возвращает новый список,
// содержащий преобразованные объекты в соответствии с заданным правилом. (Компаратор)

    //10. Функция суммирования элементов списка: Напишите лямбда-выражение, которое принимает список чисел и возвращает их сумму.
    public Integer listSum(List<Integer> list) {
        IOneParametr<List<Integer>, Integer> sum = l -> l.stream().mapToInt(i -> i).sum();
        return sum.start(list);
    }
//2023-08-28
// 1. Найдите сумму всех чисел в списке с помощью лямбда-выражения.
//Пример ввода: 1, 2, 3, 4, 5
//Пример вывода: 15 (Решено выше)


    //2. Удалите все слова с длиной меньше 5 символов из списка с помощью лямбда-выражения.
//Пример ввода: "apple", "banana", "cat", "dog", "elephant"
//Пример вывода: "banana", "elephant"
//
    public List<String> wordsMoreThenFive(List<String> strings) {
        IOneParametr<String, Boolean> filter = s -> s.length() < 5;

        ArrayList<String> list2 = new ArrayList<>();
        for (String str : strings) {
            if (!filter.start(str)) {
                list2.add(str);
            }
        }

/*        for (String i : strings) {
            if (i.length() < 5) {
                list.add(i);
            }
        }
       ArrayList<String> strings1 = list;
*/
        return list2;
    }

    //3. Найдите наименьшее число в списке с помощью лямбда-выражения.
//Пример ввода: 8, 3, 5, 1, 10
//Пример вывода: 1
    public int minimal(List<Integer> list) {
//        IOneParametr<List<Integer>, Integer> per = n -> n.stream().mapToInt(i -> i).min().getAsInt();
        ITwoParametrs<Integer> per = (n, m) -> n > m ? m : n;
        int min = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            min = per.start(min, list.get(i));
        }
/*            if (i<min) {
                min = i;
            }
        }

 */

        return min;
    }

    //6. Найдите среднее арифметическое всех чисел в списке с помощью лямбда-выражения.
//Пример ввода: 1, 2, 3, 4, 5
//Пример вывода: 3.0
    public double average(List<Integer> list) {
//        IOneParametr<List<Integer>, Double> av = n -> n.stream().mapToInt(i->i).average().getAsDouble();
        IOneParametr<List<Integer>, Double> av = n -> {
            int summ = 0;
            for (Integer i : n) {
                summ += i;
            }

            return summ / (double) n.size();
        };
        return av.start(list);
    }


    //
//4. Отсортируйте список строк в алфавитном порядке с помощью лямбда-выражения.
//Пример ввода: "apple", "cat", "banana", "dog"
//Пример вывода: "apple", "banana", "cat", "dog"
    public List<String> sortAlphabet(List<String> list){
        UnaryOperator<List<String>> m = n -> {
            n.sort(String::compareTo);
            return n;
        };
        return m.apply(list);
    }
    //вариант 2
    public static List<String> sortAlphabet2(List<String> list){
        UnaryOperator<List<String>> m = n -> {
            for (int i = 1; i < n.size(); i++) {
                String temp = n.get(i);
                int j = i-1;
                while (j >=0 && n.get(j).compareTo(temp) == 1) {
                    n.set(j + 1, n.get(j));
                    j--;
                }
                n.set(j+1, temp);
            }
            return n;
        };
        m.apply(list);
        return list;
    }
//
//5. Удалите все отрицательные числа из списка с помощью лямбда-выражения.
//Пример ввода: -5, 10, -3, 8, -2
//Пример вывода: 10, 8

    public List<Integer> removeOtricChisla(List<Integer> list) {
        UnaryOperator<List<Integer>> filter = f -> {
            Function<Integer, Boolean> b = n -> n >= 0;
            List<Integer> list1 = new ArrayList<>();
            for (Integer i : f) {
                if (b.apply(i)) list1.add(i);
            }
            return list1;
        };
        return filter.apply(list);
    }


    //
//7. Приведите все строки в списке к верхнему регистру с помощью лямбда-выражения.
//Пример ввода: "apple", "banana", "cat", "dog"
//Пример вывода: "APPLE", "BANANA", "CAT", "DOG"
//
    public List<String> upperCase(List<String> strings) {
        List<String> strings1 = new ArrayList<>();
        for (String s : strings) {

            strings1.add(s.toUpperCase());
        }
        return strings1;
    }

    //8. Вычислите произведение всех чисел в списке с помощью лямбда-выражения.
//Пример ввода: 1, 2, 3, 4, 5
//Пример вывода: 120
//
    public Integer multiply(List<Integer> list) {
        IOneParametr<List<Integer>, Integer> m = n -> {
            int p = n.get(0);
            for (int i = 1; i < n.size(); i++) {
                p = p * list.get(i);
            }
            return p;
            //return Collections.singletonList(p); Что это такое?
        };
        return m.start(list);
    }

    //9. Удалите все элементы с нечетными индексами из списка с помощью лямбда-выражения.
//Пример ввода: 1, 2, 3, 4, 5
//Пример вывода: 1, 3, 5
//
    public List<Integer> chetNeChet(List<Integer> list) {
        IOneParametr<Integer, Boolean> m = n -> n % 2 == 0;
        List<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (m.start(i)) list1.add(list.get(i));
        }
        return list1;
    }

    //10. Проверьте, являются ли все элементы в списке положительными числами с помощью лямбда-выражения.
//Пример ввода: 1, 2, 3, -4, 5
    public Boolean checkPolozit(List<Integer> list) {
        IOneParametr<List<Integer>, Boolean> m = n -> {
            for (Integer i : n) {
                if (i < 0) return false;
            }
            return true;
        };
        return m.start(list);
    }


}
