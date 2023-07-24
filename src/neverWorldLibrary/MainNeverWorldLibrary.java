package neverWorldLibrary;

import java.util.Scanner;

public class MainNeverWorldLibrary {
    public static void main(String[] args) {
        Dungeon dungeon = new Dungeon();
        System.out.println(" список ");
        dungeon.printList();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Выбрать тип персонажа:");
            System.out.println("1. Герой");
            System.out.println("2. Босс");
            System.out.println("3. Очистить список");
            System.out.println("4. Закончить");
            int n = scanner.nextInt();
            if (n == 4){
                break;
            }else if (n == 1) {
                Hero hero = new Hero();
                FillCharactersAndPrint(hero, dungeon);
            } else if (n == 2){
                Boss boss = new Boss();
                FillCharactersAndPrint(boss, dungeon);
            }else if (n == 3) {
                dungeon.clearList();
            }
       }

    }
    static void FillCharactersAndPrint(BaseCharacter character, Dungeon dungeon){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите Имя Персонажа: ");
        String name = scanner.next();
        character.setName(name);
        System.out.println("Введите количество здоровья Персонажа (не более 5000 для Героя и 10 000 для Босса)");
        character.setHealthPoints(scanner.nextInt());
        System.out.println("Введите количество урона в секунду (не меньше нуля)");
        character.setDamagePerSecond(scanner.nextInt());
        System.out.println("Выбрать тип персонажа (DD, H, T или B)");
        character.setCharacterType(CharacterType.valueOf(scanner.next()));
        dungeon.addCharacter(character);
        System.out.println(" список ");
        dungeon.printList();
        System.out.println("Сложность подземелья: " +dungeon.CheckDifficulty() + " " + dungeon.toString());
    }


}
