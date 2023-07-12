package smartphone;


public class MainSmartphone {
    public static void main(String[] args) {
       Factory factory = new Factory();
       factory.fillSmartphones(10);
       Customer customer1 = new Customer("Vasya", (byte) 9);
       Customer customer2 = new Customer("Petya", (byte) 3);
       Customer customer3 = new Customer("Sasha", (byte) 5);
       factory.addCustomer(customer1);
       factory.addCustomer(customer2);
       factory.addCustomer(customer3);
       factory.printCustomers();
       factory.printSmartPhones();
       factory.SaleSmartphone();
       factory.printCustomers();
       factory.printSmartPhones();
    }
}
