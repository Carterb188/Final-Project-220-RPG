public class Weapon{
    public int damage;
    public int numAttacks;
    public Boolean aoe;
    public Boolean pain;

    public Weapon(int damage, int numAttacks, Boolean aoe, Boolean pain){
        this.damage = damage;
        this.numAttacks = numAttacks;
        this.aoe = aoe;
        this.pain = pain;
    }

    //Weapon options already created
    public static Weapon knife = new Weapon(2, 2, false, false);
    public static Weapon sword = new Weapon(4, 1, false, false);
    public static Weapon boomerange = new Weapon(1, 1, true, false);
    public static Weapon greekFire = new Weapon(3, 1, true, true);
    public static Weapon devNuke = new Weapon(1000, 1, true, false);
}
