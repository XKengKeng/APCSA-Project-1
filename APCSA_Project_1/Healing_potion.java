public class Healing_potion {
    private int price;
    private String itemName;
    private int heal;
    public Healing_potion() {
        this.price= 25;
        this.itemName= "Healing Potion";
        this.heal = 35;
    }
    public Healing_potion(int price, String itemName,int heal) {
        this.price= price;
        this.itemName= itemName;
        this.heal = heal;
    }
    public int getPrice() {
        return price;
    }
    public String getItemName() {
        return itemName;
    }
    public int getHeal() {
        return heal;
    }

}
