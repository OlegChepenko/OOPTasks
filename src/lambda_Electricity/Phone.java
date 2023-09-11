package lambda_Electricity;

public class Phone implements IElectricity{
    @Override
    public void on() {
        System.out.println("Поставили телефон на зарядку");
    }
}
