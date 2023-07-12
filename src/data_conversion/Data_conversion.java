package data_conversion;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Stream;
public class Data_conversion {
//    У учетной записи (класс Account) есть имя (поле name) и электронный ящик (поле email).
//    Нужно, чтобы метод getEmails(ArrayList<Account>) в классе Solution
//    возвращал поток электронных ящиков всех учетных записей из списка, полученного в качестве входящего аргумента.
//
//    Подсказка:
//    Для преобразования потока данных одного типа в другой используй метод map() объекта типа Stream<Account>.
//
//    Метод main() не принимает участие в тестировании.
//
//    Требования:
//•	В публичном статическом методе getEmails(ArrayList<Account>) нужно вызывать метод map() объекта типа Stream<Account>.
//•	Метод getEmails(ArrayList<Account>) нужно реализовать согласно условию.
public static void main(String[] args) {
    var accounts = new ArrayList<Account>();
    Collections.addAll(accounts,
            new Account("Elly", "elly@yandex.ru"),
            new Account("Jocker", "jocker@gmail.com"),
            new Account("Neo", "neo@yahoo.com"));

    Stream<String> emails = getEmails(accounts);
    emails.forEach(System.out::println);
}

    public static Stream<String> getEmails(ArrayList<Account> accounts) {
        //напишите тут ваш код
        return accounts.stream().map(Account::getEmail);
    }
}
