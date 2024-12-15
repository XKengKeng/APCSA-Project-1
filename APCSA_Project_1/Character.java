import java.util.ArrayList;

public class Character {
    private int strength;
    private int armor;
    private int maxHealth;
    private int health;
    private int level;
    private int money;
    private int day;
    private int special;
    private String characterName;
    private String playerName;
    ArrayList<Healing_potion> item =  new ArrayList<Healing_potion>();


    public Character(String characterName, String playerName) {
        this.characterName = characterName;
        this.playerName = playerName;

        if (characterName.equalsIgnoreCase("Samurai")){
            strength = 50;
            armor = 10;
            maxHealth = 125;
        }
        if (characterName.equalsIgnoreCase("Warrior")){
            strength = 45;
            armor = 20;
            maxHealth = 200;
        }
        if (characterName.equalsIgnoreCase("Assassin")){
            strength = 70;
            armor = 5;
            maxHealth = 80;
        }
        money = 40;
        level = 1;
        day = 0;
    }

    public void levelUp() {
        level++;
        money+=20;
        strength += 5;
        armor += 2;
        maxHealth += 10;
        if (characterName.equalsIgnoreCase("Samurai")) {
            special += 10; 
        } else if (characterName.equalsIgnoreCase("Warrior")) {
            special += 10; 
        } else if (characterName.equalsIgnoreCase("Assassin")) {
            special += 5; 
        }
        System.out.println(getStatus());
    }

    public String getStatus() {
        return "Level: " + level +", Strength: " + strength +", Armor: " + armor +", Health: " + health +", special: " + special +", Money: " + money +", Day: " + day;
    }
    public void meditate() {
        int a=25+special;
        health+=a;
        System.out.println(playerName + " meditated and restored "+a+" health.");
    }
    public void berserk() {
        int a = 5+ special;
        strength += a;
        System.out.println(playerName + " used berserk, increasing strength by "+a+".");
    }
    public int backstab() {
        int damage = (int)(strength * 1.5 + special);
        System.out.println(playerName + " backstabed the target for "+ damage+" damage.");
        return damage;
    }
    public void sleep(){
        health =maxHealth;
    }
    public int getHealth(){
        return health;
    }
    public int getArmor(){
        return armor;
    }
    public int getStrength(){
        return strength;
    }
    public int getMoney() {
        return money;
    }
    public void setHealth(int a) {
        int effectiveDamage =(int)(a /(1.0 + armor));
        health-= effectiveDamage;
        System.out.println("You recieved " + effectiveDamage + "damage");
        if (health < 0) {
            health = 0;
        }
    }
    public void setHealth1(int b){
        health+= b;
    }
    public void nextDay(){
        day++;
        System.out.println("\nNext day...");
    }
    public void buyPotion(String potionName) {
        Healing_potion potion = null;
    
        if (potionName.equalsIgnoreCase("Healing_potion")) {
            if (money >= 20){
                potion = new Healing_potion();
                money -= 20;
                addPotion(potion);
            } 
            else {
                System.out.println("You do not have enough money to buy this potion.");
            }
        } 
        else if (potionName.equalsIgnoreCase("Damage_potion")) {
            if (money >= 15) {
                potion = new Damage_potion();
                money -= 15;
                addPotion(potion);
            } 
            else {
                System.out.println("You do not have enough money to buy this potion.");
            }
        } 
        else if (potionName.equalsIgnoreCase("Strength_potion")) {
            if (money >= 20) {
                potion = new Strength_potion();
                money -= 20;
                addPotion(potion);
            } 
            else {
                System.out.println("You do not have enough money to buy this potion.");
            }
        } 
        else {
            System.out.println("Invalid potion name. Please try again.");
        }
    }
    
    public void addPotion(Healing_potion potion) {
        if (potion != null) {
            item.add(potion);
            System.out.println(potion.getItemName() + " added to inventory.");
        }
    }
    
    public void getInventory() {
        if (item.isEmpty()){
            System.out.println("Inventory is empty.");
            return;
        }
    
        System.out.println("Inventory:");
        for (Healing_potion potion:item){
            System.out.println("- "+ potion.getItemName());
        }
    }
    public void setStrength(int a) {
        strength += a;
    }
}
