package warrior;

public class Warrior {
    private int health;
    private int lossOfHealth;

    public Warrior(int health, int lossOfHealth) {
        this.health = health;
        this.lossOfHealth = lossOfHealth;
    }
    public int getHealth(){ return health; };
    public int getLossOfHealth(){ return lossOfHealth; }
//    public int calcBalanceOfHealth(){ return health - lossOfHealth; }

}
