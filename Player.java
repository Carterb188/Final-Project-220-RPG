public class Player extends Character{

    public Weapon[] inventory = {Weapon.sword, Weapon.knife, Weapon.boomerange, Weapon.greekFire, Weapon.devNuke};
    public int hp;
    public int coin;

    public Player(String name, int maxHp){
        super(name, maxHp);
        this.hp = maxHp;
        this.coin = 0;
    }

    public void attack(Encounter encounter,int WeaponChoice){
       
        int enemyChoice;
        Weapon weapon = this.inventory[WeaponChoice];

        int i = 0;
        while( i < weapon.numAttacks && encounter.maxHp > 0){
            i++;
            
            if(!Main.player.inventory[WeaponChoice].aoe){

                //Chose Enemy if weapon is not aoe
                enemyChoice =  GameLogic.pickEnemy(encounter);
            }else{
                enemyChoice = 0;
            }
            
            if(weapon.pain){
                this.hp -= weapon.damage;
                System.out.println("You did " + Integer.toString(weapon.damage) +" to yourself!");
            }
            if(weapon.aoe || encounter.enemies.length == 1){
                for(Enemy enemy: encounter.enemies){
                    enemy.hp -= weapon.damage;
                    encounter.maxHp -= weapon.damage;
                }
                System.out.println("You did " + Integer.toString(weapon.damage) + " to all enemies!");
            }else{
                Enemy target = encounter.enemies[enemyChoice];
                target.hp -= weapon.damage;
                encounter.maxHp -= weapon.damage;
                }
            
            
            
        }
    }

   

    
    
}
