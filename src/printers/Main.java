package printers;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String s = "Meantime we shall express our darker purpose";

        LinePrinter linePrinter = new LinePrinter(10);
        linePrinter.print(s);

        NumberedLinePrinter numberedLinePrinter = new NumberedLinePrinter(10);
        numberedLinePrinter.print(s);

        HidingLinePrinter hidingLinePrinter = new HidingLinePrinter(10, new char[] {'e', 'a', 'o'});
        hidingLinePrinter.print(s);

        ArrayList<String> list = new ArrayList<>(Arrays.asList("word", "project", "inheritance", "main"));
        linePrinter.fancyPrint(list);
    }
}
