package warrior;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Warrior Duncan = new Warrior(100,20);
        Warrior Arnold = new Warrior(100,20);
        int balanceOfHealthUnit1 = Duncan.getHealth();
        int balanceOfHealthUnit2 = Arnold.getHealth();
        while (balanceOfHealthUnit1>0 && balanceOfHealthUnit2>0) {
            int unitMove = random.nextInt(1, 3);
            if (unitMove == 1){
                balanceOfHealthUnit2 -= Arnold.getLossOfHealth();
                System.out.println("Атаковал Duncan. Остаток здоровья Arnold : " + balanceOfHealthUnit2);
            }else {
                balanceOfHealthUnit1 -= Duncan.getLossOfHealth();
                System.out.println("Атаковал Arnold. Остаток здоровья Duncan 1: " + balanceOfHealthUnit1);
            }

        }
        if (balanceOfHealthUnit1 > balanceOfHealthUnit2) {
            System.out.println("Победил Duncan");
        }else System.out.println("Победил Arnold");
    }
}
