package printers;

import java.util.ArrayList;

public class NumberedLinePrinter extends LinePrinter {

    public NumberedLinePrinter(int n) {
        super(n);
    }

    @Override
    public void print(String s) {
        ArrayList<String> list = splitLine(s);
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + "." + list.get(i));
        }
    }
}
