public class Elite_enemy1 extends Enemy{

    public Elite_enemy1() {
        setHealth1(100);
        setStrength(45);
        setArmor(10);
        setName("Dragon");
    }

    public int fireball(){
        System.out.println("Dragon threw a fire ball at you");
        return 45;
    }
}