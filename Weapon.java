public class Weapon{
    public int damage;
    public int numAttacks;
    public Boolean aoe;
    public Boolean pain;
    public Boolean locked;

    public Weapon(Boolean locked,int damage, int numAttacks, Boolean aoe, Boolean pain){
        this.damage = damage;
        this.numAttacks = numAttacks;
        this.aoe = aoe;
        this.pain = pain;
        this.locked = locked;
    }

    //Weapon options already created
    public static Weapon knife = new Weapon(true, 2, 2, false, false);
    public static Weapon sword = new Weapon(false,4, 1, false, false);
    public static Weapon boomerange = new Weapon(true,1, 1, true, false);
    public static Weapon greekFire = new Weapon(true,3, 1, true, true);
    public static Weapon devNuke = new Weapon(true,1000, 1, true, false);
}
