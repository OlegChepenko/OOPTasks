package stream_task;

import com.bethecoder.ascii_table.ASCIITable;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {

    static ArrayList<City> readFile()  {
        ArrayList<City> cities = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader("spisok_gorodov.txt"))) {
            String header = reader.readLine();

            String line;
            while ((line = reader.readLine()) != null) {
                String[] a = line.split(";");
                try {
                    City city = new City(a[1], a[2], a[3], Integer.parseInt(a[4]), Integer.parseInt(a[5]));
                    cities.add(city);
                } catch (Exception exc) {
                }
            }
        }
        catch (IOException exc) {
        }

        return cities;
    }

    static boolean checkRegion(City city) {
        return city.getRegion().equals("Алтайский край");
    }

    static void showCities(List<City> cities) {
        int maxCount = 50;//сколько записей выводится максимально
        int currentPage = 0;//текущая страница. Если тут будет значение 2 - нужно будет пропустить 100 записей и взять следующие 50
        int countPages = (int)Math.ceil((double)cities.size() / maxCount);
        Scanner scanner = new Scanner(System.in);

        int action;
        do {
            List<City> result = cities.stream().skip(currentPage * maxCount).limit(maxCount).toList();

            String[] header = {"Название", "Регион", "Округ", "Численность", "Год"};
            String[][] data = new String[result.size()][5];
            for (int i = 0; i < result.size(); i++) {
                data[i][0] = result.get(i).getName();
                data[i][1] = result.get(i).getRegion();
                data[i][2] = result.get(i).getArea();
                data[i][3] = String.valueOf(result.get(i).getPopulation());
                data[i][4] = String.valueOf(result.get(i).getYear());
            }
            ASCIITable.getInstance().printTable(header, data);

            System.out.println("1.Назад 2.Вперед 3.Выход");
            action = Integer.parseInt(scanner.nextLine());
            if (action == 1) {
                if (currentPage > 0)
                    currentPage--;
            }
            else if (action == 2) {
                if (currentPage < countPages - 1) {
                    currentPage++;
                }
            }
        }
        while (action != 3);
    }

    public static void main(String[] args) throws IOException {
        ArrayList<City> cities = readFile();

        //ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(20, 6, 2));
        //List<Integer> resilt = numbers.stream().map(t -> t * t).toList();


        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1.Найти города по заданному региону");
            System.out.println("2.Получить все регионы");
            System.out.println("3.Сортировка по численности");
            System.out.println("4.Поиск города по названию");
            System.out.println("5.Найти самый старый город");
            System.out.println("6.Вывести все города");
            System.out.println("7.Средняя численность");
            System.out.println("8.Показать сколько городов есть по регионам");

            int action = Integer.parseInt(scanner.nextLine());


            if (action == 1) {
                System.out.println("Введите регион");
                String region = scanner.nextLine();
                List<City> result = cities.stream().filter(t -> t.getRegion().equals(region)).toList();
                //List<City> result = cities.stream().filter(Main::checkRegion).toList();
//                for(City city : result) {
//                    System.out.println(city.getName());
//                }
                showCities(result);
            }
            else if (action == 2) {
                List<String> regions = cities.stream().map(City::getRegion).distinct().toList();
                regions.forEach(System.out::println);
            }
            else if (action == 3) {
                List<City> result = cities.stream().sorted(Comparator.comparingInt(City::getPopulation)).toList();
                for(City city : result) {
                    System.out.println(city.getName() + " " + city.getPopulation());
                }
            }
            else if (action == 4) {
                System.out.println("Введите название города");
                String cityName = scanner.nextLine();

                Optional<City> optionalCity = cities.stream().filter(t -> t.getName().equals(cityName)).findFirst();
                if (optionalCity.isPresent()) {
                    City city = optionalCity.get();
                    System.out.println(city.getPopulation() + " " + city.getYear());
                }
                else {
                    System.out.println("Нет такого города");
                }
            }
            else if (action == 5) {
                Optional<City> result = cities.stream().min(Comparator.comparingInt(City::getYear));
                if (result.isPresent()) {
                    System.out.println(result.get().getName() + " " + result.get().getYear());
                }
            }
            else if (action == 6) {
                showCities(cities);
            }
            else if (action == 7) {
                OptionalDouble result = cities.stream().mapToInt(City::getPopulation).average();
                if (result.isPresent())
                    System.out.println(result.getAsDouble());
            }
            else if (action == 8){
                //формируем словарь "регион + города в этом регионе":
//               Map<String, List<City>> groups = cities.stream().collect(Collectors.groupingBy(City::getRegion));
                //печатаем этот словарь
//               groups.forEach((key, value) ->System.out.println(key + " - " + value.size()));
               //формируем словарь "регион + города в этом регионе", как мы делали раньше:
//                for (var entry : groups.entrySet()) {
//                    System.out.println(entry.getKey() + " - " + entry.getValue());
//                }
               ////второй способ вывода forEach через поток:
//                groups.entrySet().stream().forEach(t -> System.out.println(t.getKey() + " - " + t.getValue().size()));
                //а это, если хотим сразу посчитать количество городов в каждом регионе:
                Map<String, Long> groups = cities.stream().collect(Collectors.groupingBy(City::getRegion, Collectors.counting()));
            }

        }
    }
}
