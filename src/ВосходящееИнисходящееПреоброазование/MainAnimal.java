package ВосходящееИнисходящееПреоброазование;
//https://youtu.be/88P-SGqIeeE
public class MainAnimal {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.eat();
        Dog dog = new Dog();
        dog.bark();
        dog.eat();

        //Upcasting - Восходящее преобразование
        Animal animal2 = new Dog();
        animal2.eat();//второго метода больше нет у Dog

        //Downcasting - Нисходящее преобразование
        Dog dog2 = (Dog) animal2;
        dog2.bark();
        dog2.eat();

    }

}
