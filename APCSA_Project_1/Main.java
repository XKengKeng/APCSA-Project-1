import java.util.Scanner;
import java.util.Random;

public class Main{
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Hi, enter your player name:");
        String playerName = scan.nextLine();
        Player player = new Player(playerName);
        String characterName = null;
        System.out.println("\nEnter the character you want to play, you can choose Samurai, Warrior, or Assassin:");
        characterName = scan.nextLine();
        while (!( characterName.equalsIgnoreCase("Samurai") || characterName.equalsIgnoreCase("Warrior") || characterName.equalsIgnoreCase("Assassin"))) {
            System.out.println("Invalid character. Please choose Samurai, Warrior, or Assassin.");
            characterName = scan.nextLine();
        }
        Character character = new Character(characterName, player.getPlayerName());
        System.out.println("\nCharacter created successfully!");
        character.sleep();
        System.out.println(character.getStatus());
        if (characterName.equalsIgnoreCase("Samurai")){
            System.out.println("Your special ability is meditate, you will heal for 15 + special");
        }
        if (characterName.equalsIgnoreCase("Warrior")){
            System.out.println("Your special ability is berserk, your stregth will increase for 5 + special");
        }
        if (characterName.equalsIgnoreCase("Assassin")){
            System.out.println("Your special ability is backstab, you will damage the opponent for strength * 1.5 + special");
        }
        System.out.println("Let's start you can choose from the action below.\n");
        

        while (character.getHealth()!=0){
            System.out.println("Go to the dungeon(just type dungeon)");
            System.out.println("Go to the shop(just type shop)");
            System.out.println("Go to sleep(just type sleep)");
            String action;
            Random rand = new Random();
            int random = rand.nextInt(4);
            action = scan.nextLine();
            while (!( action.equalsIgnoreCase("dungeon") || action.equalsIgnoreCase("shop") || action.equalsIgnoreCase("sleep"))) {
                System.out.println("Invalid action. Please choose dungeon, shop, or sleep");
                action = scan.nextLine();
            }
            if (action.equalsIgnoreCase("dungeon")){
                System.out.println("\nYou went to the dungeon");
                System.out.println("You can type status to see your current status, type attack to use basic attack, type ability to use your special attack, type item to use an item.");
                
                
                if (random == 0){
                    Enemy enemy = new Enemy();
                    enemy.appear();
                    while (character.getHealth()!=0&&enemy.getHealth()!=0){
                        System.out.println("\nChoose your action: attack, ability, item, status");
                        String fightingAction = scan.nextLine();
                        while (!( fightingAction.equalsIgnoreCase("attack") || fightingAction.equalsIgnoreCase("ability") || fightingAction.equalsIgnoreCase("item")|| fightingAction.equalsIgnoreCase("status"))) {
                            System.out.println("Invalid action. Please choose attack, ability, item, or status");
                            fightingAction = scan.nextLine();
                        }
                        while (fightingAction.equalsIgnoreCase("status")) {
                            System.out.println(character.getStatus());
                            System.out.println("Choose your action: attack, ability, item, status");
                            fightingAction = scan.nextLine();
                        }
                        if (fightingAction.equalsIgnoreCase("attack")){
                            enemy.setHealth(character.getStrength());
                        }
                        if (fightingAction.equalsIgnoreCase("ability")&&characterName.equalsIgnoreCase("Samurai")){
                            character.meditate();
                        }
                        if (fightingAction.equalsIgnoreCase("ability")&&characterName.equalsIgnoreCase("Warrior")){
                            character.berserk();
                        }
                        if (fightingAction.equalsIgnoreCase("ability")&&characterName.equalsIgnoreCase("Assassin")){
                            enemy.setHealth(character.backstab());
                        }
                        if (fightingAction.equalsIgnoreCase("item")) {
                            character.getInventory();
                            System.out.println("Enter the potion name to use:");
                            String potionName= scan.nextLine();
                            
                            Healing_potion selectedPotion= null;
                            for (Healing_potion potion:character.item) {
                                if (potion.getItemName().equalsIgnoreCase(potionName)) {
                                    selectedPotion = potion;
                                    break;
                                }
                            }
                        
                            if (selectedPotion == null) {
                                System.out.println("Invalid potion name or potion not found.");
                            }
                            else {
                                if (selectedPotion.getPrice()== 25) {
                                    int healAmount = selectedPotion.getHeal();
                                    character.setHealth1(healAmount);
                                    System.out.println("You used " + selectedPotion.getItemName() + ", restoring " + healAmount + " health!");
                                } 
                                else if (selectedPotion.getPrice() == 15) {
                                    Damage_potion damagePotion = (Damage_potion) selectedPotion;
                                    enemy.setHealth(damagePotion.getDamage());
                                    System.out.println("You used " + selectedPotion.getItemName() + ", dealing " + damagePotion.getDamage() + " damage to the enemy!");
                                } 
                                else if (selectedPotion.getPrice()== 20) {
                                    Strength_potion strengthPotion = (Strength_potion) selectedPotion;
                                    character.setStrength(strengthPotion.getStrength());
                                    System.out.println("You used " + selectedPotion.getItemName() + ", increasing your strength by " + strengthPotion.getStrength() + "!");
                                }
                                character.item.remove(selectedPotion);
                            }
                        }                        
                        int attackRandom = rand.nextInt(2);
                        if (attackRandom == 0){
                            character.setHealth(enemy.getStrength());
                        }
                        if (attackRandom == 1 && enemy.getHealth()!=0){
                            enemy.heal();
                        }
                    }
                    if (character.getHealth()==0){
                        System.out.println("\nGG, game over");
                    }
                    if (enemy.getHealth()==0 && character.getHealth()>0){
                        System.out.println("\nYou killed your enemy and leveled up\n");
                        character.levelUp();
                    }
                }
                if (random == 1){
                    Enemy2 enemy = new Enemy2();
                    enemy.appear();
                    while (character.getHealth()!=0&&enemy.getHealth()!=0){
                        System.out.println("\nChoose your action: attack, ability, item, status");
                        String fightingAction = scan.nextLine();
                        while (!( fightingAction.equalsIgnoreCase("attack") || fightingAction.equalsIgnoreCase("ability") || fightingAction.equalsIgnoreCase("item")|| fightingAction.equalsIgnoreCase("status"))) {
                            System.out.println("Invalid action. Please choose attack, ability, item, or status");
                            fightingAction = scan.nextLine();
                        }
                        while (fightingAction.equalsIgnoreCase("status")) {
                            System.out.println(character.getStatus());
                            System.out.println("Choose your action: attack, ability, item, status");
                            fightingAction = scan.nextLine();
                        }
                        if (fightingAction.equalsIgnoreCase("attack")){
                            enemy.setHealth(character.getStrength());
                        }
                        if (fightingAction.equalsIgnoreCase("ability")&&characterName.equalsIgnoreCase("Samurai")){
                            character.meditate();
                        }
                        if (fightingAction.equalsIgnoreCase("ability")&&characterName.equalsIgnoreCase("Warrior")){
                            character.berserk();
                        }
                        if (fightingAction.equalsIgnoreCase("ability")&&characterName.equalsIgnoreCase("Assassin")){
                            enemy.setHealth(character.backstab());
                        }
                        if (fightingAction.equalsIgnoreCase("item")) {
                            character.getInventory();
                            System.out.println("Enter the potion name to use:");
                            String potionName= scan.nextLine();
                            
                            Healing_potion selectedPotion= null;
                            for (Healing_potion potion:character.item) {
                                if (potion.getItemName().equalsIgnoreCase(potionName)) {
                                    selectedPotion = potion;
                                    break;
                                }
                            }
                        
                            if (selectedPotion == null) {
                                System.out.println("Invalid potion name or potion not found.");
                            }
                            else {
                                if (selectedPotion.getPrice()== 25) {
                                    int healAmount = selectedPotion.getHeal();
                                    character.setHealth1(healAmount);
                                    System.out.println("You used " + selectedPotion.getItemName() + ", restoring " + healAmount + " health!");
                                } 
                                else if (selectedPotion.getPrice() == 15) {
                                    Damage_potion damagePotion = (Damage_potion) selectedPotion;
                                    enemy.setHealth(damagePotion.getDamage());
                                    System.out.println("You used " + selectedPotion.getItemName() + ", dealing " + damagePotion.getDamage() + " damage to the enemy!");
                                } 
                                else if (selectedPotion.getPrice()== 20) {
                                    Strength_potion strengthPotion = (Strength_potion) selectedPotion;
                                    character.setStrength(strengthPotion.getStrength());
                                    System.out.println("You used " + selectedPotion.getItemName() + ", increasing your strength by " + strengthPotion.getStrength() + "!");
                                }
                                character.item.remove(selectedPotion);
                            }
                        }
                        int attackRandom2 = rand.nextInt(2);
                        if (attackRandom2 == 0){
                            character.setHealth(enemy.getStrength());
                        }
                        if (attackRandom2 == 1){
                            character.setHealth(enemy.damageBone());
                        }
                    }
                    if (character.getHealth()==0){
                        System.out.println("\nGG, game over");
                    }
                    if (enemy.getHealth()==0){
                        System.out.println("\nYou killed your enemy and leveled up\n");
                        character.levelUp();
                    }
                }
                if (random == 2){
                    Enemy3 enemy = new Enemy3();
                    enemy.appear();
                    while (character.getHealth()!=0&&enemy.getHealth()!=0){
                        System.out.println("\nChoose your action: attack, ability, item, status");
                        String fightingAction = scan.nextLine();
                        while (!( fightingAction.equalsIgnoreCase("attack") || fightingAction.equalsIgnoreCase("ability") || fightingAction.equalsIgnoreCase("item")|| fightingAction.equalsIgnoreCase("status"))) {
                            System.out.println("Invalid action. Please choose attack, ability, item, or status");
                            fightingAction = scan.nextLine();
                        }
                        while (fightingAction.equalsIgnoreCase("status")) {
                            System.out.println(character.getStatus());
                            System.out.println("Choose your action: attack, ability, item, status");
                            fightingAction = scan.nextLine();
                        }
                        if (fightingAction.equalsIgnoreCase("attack")){
                            enemy.setHealth(character.getStrength());
                        }
                        if (fightingAction.equalsIgnoreCase("ability")&&characterName.equalsIgnoreCase("Samurai")){
                            character.meditate();
                        }
                        if (fightingAction.equalsIgnoreCase("ability")&&characterName.equalsIgnoreCase("Warrior")){
                            character.berserk();
                        }
                        if (fightingAction.equalsIgnoreCase("ability")&&characterName.equalsIgnoreCase("Assassin")){
                            enemy.setHealth(character.backstab());
                        }
                        if (fightingAction.equalsIgnoreCase("item")) {
                            character.getInventory();
                            System.out.println("Enter the potion name to use:");
                            String potionName= scan.nextLine();
                            
                            Healing_potion selectedPotion= null;
                            for (Healing_potion potion:character.item) {
                                if (potion.getItemName().equalsIgnoreCase(potionName)) {
                                    selectedPotion = potion;
                                    break;
                                }
                            }
                        
                            if (selectedPotion == null) {
                                System.out.println("Invalid potion name or potion not found.");
                            }
                            else {
                                if (selectedPotion.getPrice()== 25) {
                                    int healAmount = selectedPotion.getHeal();
                                    character.setHealth1(healAmount);
                                    System.out.println("You used " + selectedPotion.getItemName() + ", restoring " + healAmount + " health!");
                                } 
                                else if (selectedPotion.getPrice() == 15) {
                                    Damage_potion damagePotion = (Damage_potion) selectedPotion;
                                    enemy.setHealth(damagePotion.getDamage());
                                    System.out.println("You used " + selectedPotion.getItemName() + ", dealing " + damagePotion.getDamage() + " damage to the enemy!");
                                } 
                                else if (selectedPotion.getPrice()== 20) {
                                    Strength_potion strengthPotion = (Strength_potion) selectedPotion;
                                    character.setStrength(strengthPotion.getStrength());
                                    System.out.println("You used " + selectedPotion.getItemName() + ", increasing your strength by " + strengthPotion.getStrength() + "!");
                                }
                                character.item.remove(selectedPotion);
                            }
                        }
                        character.setHealth(enemy.getStrength());
                    }
                    if (character.getHealth()==0){
                        System.out.println("\nGG, game over");
                    }
                    if (enemy.getHealth()==0){
                        System.out.println("\nYou killed your enemy and leveled up\n");
                        character.levelUp();
                    }
                }
                if (random == 3){
                    Elite_enemy1 enemy = new Elite_enemy1();
                    enemy.appear();
                    while (character.getHealth()!=0&&enemy.getHealth()!=0){
                        System.out.println("\nChoose your action: attack, ability, item, status");
                        String fightingAction = scan.nextLine();
                        while (!( fightingAction.equalsIgnoreCase("attack") || fightingAction.equalsIgnoreCase("ability") || fightingAction.equalsIgnoreCase("item")|| fightingAction.equalsIgnoreCase("status"))) {
                            System.out.println("Invalid action. Please choose attack, ability, item, or status");
                            fightingAction = scan.nextLine();
                        }
                        while (fightingAction.equalsIgnoreCase("status")) {
                            System.out.println(character.getStatus());
                            System.out.println("Choose your action: attack, ability, item, status");
                            fightingAction = scan.nextLine();
                        }
                        if (fightingAction.equalsIgnoreCase("attack")){
                            enemy.setHealth(character.getStrength());
                        }
                        if (fightingAction.equalsIgnoreCase("ability")&&characterName.equalsIgnoreCase("Samurai")){
                            character.meditate();
                        }
                        if (fightingAction.equalsIgnoreCase("ability")&&characterName.equalsIgnoreCase("Warrior")){
                            character.berserk();
                        }
                        if (fightingAction.equalsIgnoreCase("ability")&&characterName.equalsIgnoreCase("Assassin")){
                            enemy.setHealth(character.backstab());
                        }
                        if (fightingAction.equalsIgnoreCase("item")) {
                            character.getInventory();
                            System.out.println("Enter the potion name to use:");
                            String potionName= scan.nextLine();
                            
                            Healing_potion selectedPotion= null;
                            for (Healing_potion potion:character.item) {
                                if (potion.getItemName().equalsIgnoreCase(potionName)) {
                                    selectedPotion = potion;
                                    break;
                                }
                            }
                        
                            if (selectedPotion == null) {
                                System.out.println("Invalid potion name or potion not found.");
                            }
                            else {
                                if (selectedPotion.getPrice()== 25) {
                                    int healAmount = selectedPotion.getHeal();
                                    character.setHealth1(healAmount);
                                    System.out.println("You used " + selectedPotion.getItemName() + ", restoring " + healAmount + " health!");
                                } 
                                else if (selectedPotion.getPrice() == 15) {
                                    Damage_potion damagePotion = (Damage_potion) selectedPotion;
                                    enemy.setHealth(damagePotion.getDamage());
                                    System.out.println("You used " + selectedPotion.getItemName() + ", dealing " + damagePotion.getDamage() + " damage to the enemy!");
                                } 
                                else if (selectedPotion.getPrice()== 20) {
                                    Strength_potion strengthPotion = (Strength_potion) selectedPotion;
                                    character.setStrength(strengthPotion.getStrength());
                                    System.out.println("You used " + selectedPotion.getItemName() + ", increasing your strength by " + strengthPotion.getStrength() + "!");
                                }
                                character.item.remove(selectedPotion);
                            }
                        }
                        int attackRandom3 = rand.nextInt(2);
                        if (attackRandom3 == 0){
                            character.setHealth(enemy.getStrength());
                        }
                        if (attackRandom3 == 1){
                            character.setHealth(enemy.fireball());
                        }
                    }
                    if (character.getHealth()==0){
                        System.out.println("\nGG, game over");
                    }
                    if (enemy.getHealth()==0){
                        System.out.println("\nYou killed your enemy, got $20, and leveled up\n");
                        character.levelUp();
                    }
                }
            }
            if (action.equalsIgnoreCase("sleep")){
                character.sleep();
                character.nextDay();
            }
            if (action.equalsIgnoreCase("shop")) {
                System.out.println("\nWelcome to the shop!");
                boolean shopping = true;
            
                while (shopping) {
                    System.out.println("\nHere are the items you can buy:");
                    System.out.println("1. Healing Potion ($25)");
                    System.out.println("2. Damage Potion ($15)");
                    System.out.println("3. Strength Potion ($20)");
                    System.out.println("4. Exit shop");
                    System.out.print("\nEnter the number corresponding to the potion you want to buy or type 'exit' to leave: ");
            
                    String shopChoice = scan.nextLine();
            
                    if (shopChoice.equals("1")) {
                        character.buyPotion("Healing_potion");
                    } else if (shopChoice.equals("2")) {
                        character.buyPotion("Damage_potion");
                    } else if (shopChoice.equals("3")) {
                        character.buyPotion("Strength_potion");
                    } else if (shopChoice.equals("4") || shopChoice.equalsIgnoreCase("exit")) {
                        System.out.println("Thank you for visiting the shop!");
                        shopping = false;
                    } else {
                        System.out.println("Invalid choice. Please select a valid option.");
                    }
            
                    if (shopping) {
                        System.out.println("\nYour remaining money: $" + character.getMoney());
                        System.out.println("Your current inventory: ");
                        character.getInventory();
                    }
                }
            }
        }
    }
}

