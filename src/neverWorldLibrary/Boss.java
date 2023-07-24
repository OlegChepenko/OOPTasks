package neverWorldLibrary;

import java.util.Arrays;

public class Boss extends BaseCharacter{



    @Override
    public int getHealthPoints() {
        return super.getHealthPoints();
    }

    @Override
    public void setHealthPoints(int healthPoints) {
        if (healthPoints > 10000){
            throw new IllegalArgumentException("Не может быть более 5000");
        }
        super.setHealthPoints(healthPoints);
    }


    @Override
    public void setCharacterType(CharacterType characterType) {
        if (CharacterType.B != (characterType)){
            throw new IllegalArgumentException("Только “B”");
        }
        super.setCharacterType(characterType);
    }

}
