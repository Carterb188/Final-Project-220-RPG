
public class Encounter {

    

    public Enemy[] enemies;
    public int maxHp = 0;

    public Encounter(Enemy[] enemies){
        this.enemies = enemies;
        for(int i = 0; i < enemies.length; i++){
            this.maxHp += enemies[i].maxHp;
        }
    }


    
    static Enemy m1 = new Enemy("Monster #1", 4, 1);
    static Enemy m2 = new Enemy("Monster #2", 4, 1);
    static Enemy m3 = new Enemy("Monster #3", 4, 1);
    public static Enemy[] enemylist_1_1 = {m1, m2, m3};

    public static Encounter encounter_1_1 = new Encounter(enemylist_1_1);

   
    static Enemy m4 = new Enemy("Monster #1", 10, 10);
    public static Enemy[] enemylist_2_1 = {m4};

    public static Encounter encounter_2_1 = new Encounter(enemylist_2_1);
    



    
   
    
    

    
}
