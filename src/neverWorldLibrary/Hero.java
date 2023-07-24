package neverWorldLibrary;

import java.util.Arrays;

public class Hero extends BaseCharacter{


    @Override
    public void setHealthPoints(int healthPoints) {
        if (healthPoints > 5000){
            throw new IllegalArgumentException("Не может быть более 5000");
        }
        super.setHealthPoints(healthPoints);
    }

    @Override
    public int getDamagePerSecond() {
        return super.getDamagePerSecond();
    }

    @Override
    public void setDamagePerSecond(int damagePerSecond) {
        super.setDamagePerSecond(damagePerSecond);
    }

    @Override
    public void setCharacterType(CharacterType characterType) {
        CharacterType[] c = {CharacterType.DD, CharacterType.H, CharacterType.T};
        if (Arrays.stream(c).noneMatch(t -> t == characterType)){
            throw new IllegalArgumentException("Только “DD”, “H”, “T” или “B”");
        }
        super.setCharacterType(characterType);
    }
}
