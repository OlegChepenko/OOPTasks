package printers;

import java.util.ArrayList;
import java.util.Comparator;

public class LinePrinter {
    private int n;

    public LinePrinter(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("Incorrect N");
        }
        this.n = n;
    }

    protected ArrayList<String> splitLine(String s) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i+=n) {
            String p;
            if (i + n < s.length()) {
                p = s.substring(i, i + n);
            }
            else {
                p = s.substring(i);
            }
            list.add(p);
        }
        return list;
    }

    public void print(String s) {
        ArrayList<String> list = splitLine(s);
        for(String p : list) {
            System.out.println(p);
        }
    }

    public void fancyPrint(ArrayList<String> list) {
        int maxLen = list.stream().max(Comparator.comparingInt(String::length)).get().length();
        for (String p : list) {
            String result = padFancy(p,maxLen);
            System.out.println(result);
        }

    }

    protected String padFancy(String s, int maxLen) {
        while (s.length() < maxLen) {
            s = getFillChar() + s;
        }
        return s;
    }

    protected char getFillChar(){
        return '#';
    }

}
