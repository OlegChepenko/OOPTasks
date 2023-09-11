package sortirovkaPuzirek_Tasks;
//2023-09-04
import delivery_system.GeoCoordinate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

//2023-09-04
public class sortirovkaPuzirek_Tasks {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(8,2,5,1,4);
        bubbleSort(list);
// 2.сортирует список строк в алфавитном порядке, используя метод сортировки вставками.
        List<String> strings = Arrays.asList("Bcd", "Cdf", "Abc");
        bubbleSortStringAlphabet(strings);
        System.out.println(strings);
// 5.сортирует список пар координат (x, y) в порядке возрастания расстояния от начала координат
        List<GeoCoordinate> coordinates = new ArrayList<>();
        GeoCoordinate coordinate1 = new GeoCoordinate(1,1);
        GeoCoordinate coordinate2 = new GeoCoordinate(2,2);
        GeoCoordinate coordinate3 = new GeoCoordinate(2,1);
        coordinates.add(coordinate1);
        coordinates.add(coordinate2);
        coordinates.add(coordinate3);
        bubbleSortDistance(coordinates);
    }
 /*
 * 1. Напишите функцию, которая сортирует список целых чисел в порядке возрастания, используя метод сортировки вставками.
 * */
    public static void bubbleSort(List<Integer> list){
        for (int i = 1; i < list.size(); i++) {
            for (int j = list.size()-1; j >= i ; j--) {
                if (list.get(j-1) > list.get(j)){
                    int tmp = list.get(j-1);
                    list.set(j-1, list.get(j));
                    list.set(j, tmp);
                }
            }
        }
    }

    /*
    * 2. Напишите функцию, которая сортирует список строк в алфавитном порядке, используя метод сортировки вставками.
     * */
    public static void bubbleSortStringAlphabet(List<String> strings){
        for (int i = 1; i < strings.size(); i++) {
            for (int j = strings.size()-1; j >= i ; j--) {
                if (strings.get(j-1).compareTo(strings.get(j)) > 0){
                    String tmp = strings.get(j-1);
                    strings.set(j-1, strings.get(j));
                    strings.set(j, tmp);
                }
            }
        }
    }

    /*
    * 3. Напишите функцию, которая сортирует список объектов класса "Студент" по их среднему баллу, используя метод сортировки вставками.
    * см. student_task
     * */

    /*
    * 4. Напишите функцию, которая сортирует список дат в хронологическом порядке, используя метод сортировки вставками.
     * */
    public static void bubbleSortDates(List<LocalDate> dates){
        for (int i = 0; i < dates.size(); i++) {
            for (int j = dates.size()-1; j >= i ; j--) {
                if (dates.get(j-1).isAfter(dates.get(j))){
                    LocalDate tmp = dates.get(j-1);
                    dates.set(j-1, dates.get(j));
                    dates.set(j, tmp);
                }
            }
        }
    }

   /*
   * 5. Напишите функцию,
   * которая сортирует список пар координат (x, y) в порядке возрастания расстояния от начала координат,
   * используя метод сортировки вставками.
   * */

    //класс GeoCoordinates находится в пакете delivery_system
    public static void bubbleSortDistance(List<GeoCoordinate> coordinates){
        for (int i = 0; i < coordinates.size(); i++) {
            for (int j = coordinates.size()-1; j >= i; j--) {
                if (coordinates.get(j-1).hypotenuse() > coordinates.get(j).hypotenuse()){
                    GeoCoordinate tmp = coordinates.get(j-1);
                    coordinates.set(j-1, coordinates.get(j));
                    coordinates.set(j, tmp);
                }
            }
        }
    }
}
