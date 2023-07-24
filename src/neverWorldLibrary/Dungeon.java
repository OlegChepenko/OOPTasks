package neverWorldLibrary;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Dungeon{
    private List<BaseCharacter> characters = new ArrayList<>();
    public void addCharacter (BaseCharacter character){
        characters.add(character);
    }

//    private int countHeroesOrBosses(CharacterType type){
//        int bosses = 0;
//        int heroes = 0;
//        for (BaseCharacter b : characters) {
//            if (b.getCharacterType().equals(CharacterType.B)){
//                bosses += 1;
//            }else {
//                heroes += 1;
//            }
//        }
//        if (type.equals(CharacterType.B)){
//            return bosses;
//        } else return heroes;
//     }
    public int countHeroes(){
        return (int) characters.stream().filter(t -> t instanceof Hero).count();
    }
    public int countBosses(){
        return (int) characters.stream().filter(t -> t instanceof Boss).count();
    }

    //Повторяющийся код в отдельный метод не вынести, т.к. усложняется реализация из за наличия нескольких типов героев.
    //Придется считать каждый тип отдельно, что не целесообразно.
    public double CheckDifficulty(){

        int bosses = countBosses();
        int heroes = countHeroes();
//        for (BaseCharacter b : characters) {
//            if (b.getCharacterType().equals(CharacterType.B)){
//                bosses += 1;
//            }else {
//                heroes += 1;
//            }
//        }
//        if (bosses == 0){
//            throw new NullPointerException("Количество боссов равно нулю!");
//        } else d = heroes/bosses;
        double d = (double) heroes/bosses;
        return d;
    }

    @Override
    public String toString() {
        return "Количество Героев: " + countHeroes()
                + ", количество Боссов: "
                + countBosses();
    }
    public void printList(){
        if (characters.isEmpty()){
            System.out.println("Список пуст");
        } else {
            for (BaseCharacter b : characters) {
                System.out.println(b.getCharacterType() + " , " + b.getName() + " , " + b.getHealthPoints());
            }
        }
    }

    public void clearList(){
        characters.clear();
    }
}
