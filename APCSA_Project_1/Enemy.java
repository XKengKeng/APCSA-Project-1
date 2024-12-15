public class Enemy {
    private int health;
    private int strength;
    private int armor;
    private String name;

    public int getHealth() {
        return health;
    }

    public void setHealth1(int health) {
        this.health = health;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void appear(){
        System.out.println( "You encounted a " + name);
    }
    public void setHealth(int a) {
        int effectiveDamage =(int)(a /(1.0 + armor));
        System.out.println(name+" recieved " + effectiveDamage + "damage");
        health-= effectiveDamage;
        System.out.println(name+" has " + health + " HP left.");
        if (health < 0) {
            health = 0;
        }
    }
    public Enemy() {
        this.health = 100;
        this.strength = 20;
        this.armor = 0;
        this.name = "Slime";
    }

    public void heal(){
        health+=20;
        System.out.println("Slime healed for 20 HP");
    }
}
