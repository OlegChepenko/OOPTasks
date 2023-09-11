package sortirovkaChetnihChiselIsFila;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
Сортировка четных чисел из файла
Ввести имя файла с консоли.
Прочитать из него набор чисел.
Вывести в консоли только четные, отсортированные по возрастанию.
*/


public class SortirovkaChetnihChiselIsFila {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        Scanner scanner = new Scanner(fileName);

        while (scanner.hasNextLine()){
            // TODO: 28.07.2023
        }

    }
}
