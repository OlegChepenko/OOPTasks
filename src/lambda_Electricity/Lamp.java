package lambda_Electricity;

public class Lamp implements IElectricity{

    @Override
    public void on() {
        System.out.println("Лампа включилась");
    }
}
