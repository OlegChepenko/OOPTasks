package generics;

public class Main_generics {
    public static void main(String[] args) {
        ListCustom <Integer>listCustom = new ListCustom<>();
        listCustom.add(1);
        listCustom.add(16);
        ListCustom<String> listCustom1 = new ListCustom<>();
        listCustom1.add("lkj;lk;");
        System.out.println(listCustom1.getElement(0));

//        System.out.println(listCustom.getElement(1));
        listCustom.remove(1);
//        System.out.println(listCustom.getElement(0));
//        System.out.println(listCustom.getElement(1));
    }
}
