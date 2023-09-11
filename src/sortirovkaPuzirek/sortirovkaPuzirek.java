package sortirovkaPuzirek;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;


//2023-09-02
public class sortirovkaPuzirek {
    public static void main(String[] args) {
//        sortAlphabet2(Arrays.asList());
    }

//    public List<String> sortAlphabet2(List<String> list){
//        UnaryOperator<List<Integer>> m = n -> {
//            for (int i = 1; i < n.size(); i++) {
//                int temp = n.get(i);
//                if (n.get(i-1) > n.get(i)){
//                    temp = n.get(i-1);
//                    n.set(i-1, n.get(i));
//                    n.set(i, temp);
//                }
//            }
//        };
//        return m.apply(list);
//    }

    public static List<Integer> sortAlphabet3(List<Integer> list){
        UnaryOperator<List<Integer>> m = n -> {
            for (int i = 1; i < n.size(); i++) {
                int temp = n.get(i);
                int j = i-1;
                while (j >=0 && n.get(j) > temp) {
                    n.set(j + 1, n.get(j));
                    j--;
                }
                    n.set(j+1, temp);
            }
            return n;
        };
        m.apply(list);
        return null;
    }
    public static List<String> sortAlphabet2(List<String> list){
        UnaryOperator<List<String>> m = n -> {
            for (int i = 1; i < n.size(); i++) {
                String temp = n.get(i);
                int j = i-1;
                while (j >=0 && n.get(j).compareTo(temp) == 1) {
                    n.set(j + 1, n.get(j));
                    j--;
                }
                n.set(j+1, temp);
            }
            return n;
        };
        m.apply(list);
        return list;
    }
}
