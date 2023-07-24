package printers;

import java.util.Random;

public class HidingLinePrinter extends NumberedLinePrinter {
    private char[] hiddenChars;
    private Random random = new Random();

    public HidingLinePrinter(int n, char[] hiddenChars) {
        super(n);
        this.hiddenChars = hiddenChars;
    }

    @Override
    public void print(String s) {
        for (int i = 0; i < hiddenChars.length; i++) {
            s = s.replace(hiddenChars[i], '*');
        }
        super.print(s);
    }

    @Override
    protected char getFillChar() {
        int c = random.nextInt(0,10);
        return (char)('0' + c);
    }
}
