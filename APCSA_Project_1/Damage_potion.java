public class Damage_potion extends Healing_potion {
    private int damage;

    public Damage_potion() {
        super(15, "Damage Potion", 0);
        this.damage = 60;
    }

    public int getDamage() {
        return damage;
    }

}