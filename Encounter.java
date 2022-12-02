
public class Encounter {

    

    public Enemy[] enemies;
    public int maxHp ;

    public Encounter(Enemy[] enemies){
        this.enemies = enemies;
        this.maxHp = 0;
        for(int i = 0; i < enemies.length; i++){
           this.maxHp += enemies[i].maxHp;
        }
       
    }


    //Encounter #1
    static Enemy m1 = new Enemy("Wolf", 4, 1);
    static Enemy m2 = new Enemy("Wolf", 4, 1);
    static Enemy m3 = new Enemy("Wolf", 4, 1);
    public static Enemy[] enemylist_1 = {m1, m2, m3};
    public static Encounter encounter_1 = new Encounter(enemylist_1);

    //Encounter #2
    static Enemy m4 = new Enemy("Troll", 10, 4);
    static Enemy m5 = new Enemy("Goblin", 2, 2);
    public static Enemy[] enemylist_2 = {m4, m5};
    public static Encounter encounter_2 = new Encounter(enemylist_2);

    //Encounter #3
    static Enemy m6 = new Enemy("Goblin", 2, 2);
    static Enemy m7 = new Enemy("Goblin", 2, 2);
    static Enemy m8 = new Enemy("Goblin", 2, 2);
    public static Enemy[] enemylist_3 = {m6, m7, m8};
    public static Encounter encounter_3 = new Encounter(enemylist_3);

    //Encounter #4
    static Enemy m9 = new Enemy("Knoll", 3, 3);
    static Enemy m10 = new Enemy("Knoll", 3, 3);
    static Enemy m11 = new Enemy("Knoll", 3, 3);
    static Enemy m12 = new Enemy("Knoll", 3, 3);
    static Enemy m13 = new Enemy("Knoll", 3, 3);
    static Enemy m14 = new Enemy("Knoll", 3, 3);
    static Enemy m15 = new Enemy("Knoll", 3, 3);
    static Enemy m16 = new Enemy("Knoll", 3, 3);
    static Enemy m17 = new Enemy("Knoll", 3, 3);
    static Enemy m18 = new Enemy("Knoll", 3, 3);
    public static Enemy[] enemylist_4 = {m9, m10, m11, m12, m13, m14, m15, m16, m17, m18};
    public static Encounter encounter_4 = new Encounter(enemylist_4);
    
    //Encounter #5 - Final Encounter
    static Enemy m19 = new Enemy("Monarch Knoll", 9, 3);
    static Enemy m20 = new Enemy("Executioner Knoll", 5, 5);
    public static Enemy[] enemylist_5 = {m20,m19};
    public static Encounter encounter_5 = new Encounter(enemylist_5);
    



    
   
    
    

    
}
