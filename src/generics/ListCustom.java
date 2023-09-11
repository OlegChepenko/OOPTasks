package generics;
//2023-09-05

public class ListCustom<T> {

    private T[] array = (T[])new Object[10];
    private int indexStopped = -1;

    public void add(T object){
        if ((indexStopped + 1) >= array.length){
            System.out.println("Невозможно добавить элемент в массив");
            return;
        }
        array[indexStopped +1] = object;
        indexStopped++;
    }

    public T getElement(int index){
        if (index < 0 || index >= array.length) {
            System.out.println("Недопустимый индекс");
            return null;
        }
        return array[index];
    }

    //метод remove нужно разделить на две части
    //Нахождение индекса, который нужно затереть
    //Сдвиг всех элементов на -1, чтобы затереть искомый элемент
    public void remove(T o){
        int index = findIndex(o);
        move(index);
    }

    public void remove(int index){
        if (index < 0 || index >= array.length) {
            System.out.println("Недопустимый индекс");
            return;
        }
        move(index);
    }

    //Нахождение индекса, который нужно затереть
    public int findIndex(T o){
        for (int i = 0; i < array.length; i++) {

            if (o.equals(array[i])){
                return i;
            }
        }
        return -1;
    }

    //Сдвиг всех элементов на -1, чтобы затереть искомый элемент
    public void move(int i){
        for (int j = i; j < array.length - 1; j++) {
            array[j] = array[j+1];
        }
        array[array.length-1] = null;
    }

}
