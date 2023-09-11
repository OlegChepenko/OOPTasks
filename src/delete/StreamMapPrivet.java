package delete;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMapPrivet {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("privet");
        list.add("kak dela?");
        list.add("OK");
        list.add("poka");
        List<Integer> list1 = list.stream().map(element -> element.length()).collect(Collectors.toList());
        System.out.println(list1);
    }

}
