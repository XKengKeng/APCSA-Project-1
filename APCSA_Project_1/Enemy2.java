public class Enemy2 extends Enemy{

    public Enemy2() {
        setHealth1(80);
        setStrength(30);
        setArmor(0);
        setName("Skeleton");
    }
    public int damageBone(){
        System.out.println("Skeleton threw its bone at you!");
        return 35;
    }
}
