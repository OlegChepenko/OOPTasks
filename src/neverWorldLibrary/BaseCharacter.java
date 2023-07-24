package neverWorldLibrary;

import java.util.Arrays;

public class BaseCharacter {
    private String name;
    private int healthPoints;
    private int damagePerSecond;
    private CharacterType characterType;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        if (name.length() < 10 || name.length() > 15){
            throw new IllegalArgumentException("Имя короче 10 или длиннее 15");
        }
        if (!name.toLowerCase().chars().allMatch(v -> v >= 'a' && v <= 'z')){
            throw new IllegalArgumentException("Буква не из англ. алфавита");
        }
        if (!Character.isUpperCase(name.charAt(0))){
            throw new IllegalArgumentException("Первая буква не заглавная");
        }
        this.name = name;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        if (healthPoints < 0){
            throw new IllegalArgumentException("Не может быть меньше нуля");
        }
        this.healthPoints = healthPoints;
    }

    public int getDamagePerSecond() {
        return damagePerSecond;
    }

    public void setDamagePerSecond(int damagePerSecond) {

        if (damagePerSecond < 0){
            throw new IllegalArgumentException("Не может быть меньше нуля");
        }
        this.damagePerSecond = damagePerSecond;
    }

    public CharacterType getCharacterType() {
        return characterType;
    }

    public void setCharacterType(CharacterType characterType) {
        this.characterType = characterType;
    }

    @Override
    public String toString() {

        return "Name: " + name + " type: " + characterType + " HP: " + healthPoints + " DPS: " + damagePerSecond;
    }
}
