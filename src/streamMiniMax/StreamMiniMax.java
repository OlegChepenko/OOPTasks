package streamMiniMax;
/*
* Реализуй метод, который возвращает объект класса Pair.
* В поле x этого объекта должно содержаться минимальное число,
* а в поле y - максимальное число из массива inputArray.
Требования:
•	Программа не должна считывать данные с клавиатуры.
•	Класс Pair не изменяй.
•	Метод main не изменяй.
•	Допиши реализацию метода getMinimumMaximumPair: он должен возвращать пару из минимума и максимума.
•	Программа должна вывести правильный результат.
•	Метод getMinimumMaximumPair не должен изменять массив inputArray.
* */

import java.util.Arrays;

public class StreamMiniMax {
    public static void main(String[] args) {
        int[] data = new int[]{1, 2, 3, 5, -2, -8, 0, 77, 5, 5};

        Pair result = getMinimumMaximumPair(data);

        System.out.println("The minimum is " + result.x);
        System.out.println("The maximum is " + result.y);
    }

    public static Pair getMinimumMaximumPair(int[] inputArray) {
        if (inputArray == null || inputArray.length == 0) {
            return new Pair(null, null);
        }

        // напишите тут ваш код
 /*       решение №1
        int[] array = inputArray.clone();
        Arrays.sort(array);
        int min = array[0];
        int max = array[array.length-1];

  */
       //решение №2
        int x = Arrays.stream(inputArray).min().getAsInt();
        int y = Arrays.stream(inputArray).max().getAsInt();

        return new Pair(x, y);
    }

    public static class Pair {
        public Integer x;
        public Integer y;

        public Pair(Integer x, Integer y) {
            this.x = x;
            this.y = y;
        }
    }
}
