package lambda_Electricity;

public class Main_Electricity {

    public static void main(String[] args) {
        Rozetka rozetka = new Rozetka();
        Lamp lamp = new Lamp();
        Phone phone = new Phone();

        rozetka.addElectricityConsumer(lamp);
        rozetka.addElectricityConsumer(phone);
        rozetka.addElectricityConsumer(() -> System.out.println("Перегрузка"));

        rozetka.on();
    }




}
