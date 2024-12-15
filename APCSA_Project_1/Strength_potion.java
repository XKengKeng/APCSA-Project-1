public class Strength_potion extends Healing_potion {
    private int strength;

    public Strength_potion() {
        super(20, "Strength Potion", 10);
        this.strength = 10;
    }


    public int getStrength() {
        return strength;
    }
}