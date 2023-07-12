package smartphone;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class Factory {
    private List<GentleSmartphone> gentleSmartphones;
    private List<Customer> customers;
    private int serialNumberOfTransformator;
    private int serialNumberOfSmartPhone;

    public Factory() {
        gentleSmartphones = new ArrayList<>();
        customers = new ArrayList<>();
    }
    /*
    * В данном классе реализовать метод SaleSmartphone(), который должен «пробежаться» по всем клиентам
    * в очереди на покупку и по возможности (при наличии) вручить каждому смартфон.
    * Если подобрать смартфон не удалось, пользователю предлагается трансформатор с нужной настройкой
    * (на повышение чувствительности датчика или на понижение). После чего из смартфонов на складе снова пытаются подобрать подходящий.
    * При этом «врученный» смартфон удаляется из коллекции смартфонов предприятия кафедры ИВТ.
    * В случае, если всем желающим выдали устройство связи, но они все равно остались на складе,
    * происходит их ликвидация (очистка коллекции смартфонов).
    * */
    public void fillSmartphones(int count){
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            TactileSensor sensor = new TactileSensor((byte) random.nextInt(1,10));
            GentleSmartphone smartphone = new GentleSmartphone(serialNumberOfSmartPhone, sensor);
            serialNumberOfSmartPhone ++;
            gentleSmartphones.add(smartphone);
        }
    }
    public void printSmartPhones(){
        System.out.println("---------------------------------------");
        System.out.println("Всего смартфонов на складе: " + gentleSmartphones.size());
        for (GentleSmartphone smartphone : gentleSmartphones) {
            System.out.println("Серийный номер: " + smartphone.getSerialNumber());
            System.out.println("Уровень чувствительности датчика: " + smartphone.getTactileSensor().getSensitivity());
        }
    }
    public void printCustomers(){
        for (Customer customer : customers) {
            System.out.println("---------------------------------------");
            System.out.println("Покупатель: " + customer.getFullName());
            //byte gentleRate = customer.getGentleRate();
            System.out.println("Уровень нежности покупателя: " + customer.getGentleRate());
            if (customer.getSmartphone() != null){
                int n = customer.getSmartphone().getSerialNumber();
                System.out.println("Серийный номер смартфона: " + n);
                byte sensitivity = customer.getSmartphone().getTactileSensor().getSensitivity();
                System.out.println("Чувствительность датчика смартфона: " + sensitivity);
            } else {
                System.out.println("У покупателя еще нет смартфона.");
            }
            if (customer.getTransformModule() != null){
            int serialNumbTransformator = customer.getTransformModule().getSerialNumber();
            System.out.println("Серийный номер трансформатора: " + serialNumbTransformator);
            String transformatorType = customer.getTransformModule().getTransformatorType().toString();
                System.out.println("Тип трансформатора: " + transformatorType);
        } else  {
                System.out.println("У покупателя нет трансформатора");
            }
        }
    }

    public void addCustomer(Customer customer){
        customers.add(customer);
    }
    public void SaleSmartphone(){
        for (Customer customer : customers) {
           Optional<GentleSmartphone> smartphone = findSmartphone(customer, 1.5, 2);
           if (smartphone.isEmpty()){
               smartphone = findSmartphone(customer, 3, 4);
               if (smartphone.isPresent()){
                   TransformatorType type;
                   if (smartphone.get().getTactileSensor().getSensitivity() > customer.getGentleRate()){
                       type = TransformatorType.MULTIPLIER;
                   } else {
                       type = TransformatorType.DIVIDER;
                   }
                  Transformator transformator = new Transformator(serialNumberOfTransformator, type);
                   serialNumberOfTransformator ++;
                   customer.setTransformModule(transformator);
               }
           }
           if (smartphone.isPresent()){
               customer.setSmartphone(smartphone.get());
               gentleSmartphones.remove(smartphone.get());
           }
        }
    }
    private Optional<GentleSmartphone> findSmartphone(Customer customer, double min, double max){
        Optional<GentleSmartphone> smartphone = gentleSmartphones.stream().filter(t->t.getTactileSensor().getSensitivity() >
                customer.getGentleRate()/min && t.getTactileSensor().getSensitivity() < customer.getGentleRate()*max).findFirst();
        return smartphone;
    }
}
