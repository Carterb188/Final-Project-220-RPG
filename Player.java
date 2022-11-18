public class Player extends Character{

    public Weapon[] inventory = {Weapon.sword, Weapon.knife, Weapon.boomerange, Weapon.greekFire};
    public int hp;
    public int coin;

    public Player(String name, int maxHp){
        super(name, maxHp);
        this.hp = maxHp;
        this.coin = 0;
    }

    public void attack(Encounter encounter){
       

        //Create prompt that will give player attack options
        String a = "Attacks: \n(1)Sword\n(2)Dagger\n(3)Boomerang\n(4)Greek Fire\n";


        //Let the player choose an option based on the prompt
        int chosenAttack = GameLogic.readInt(a, 4);
        

        //Selected Chosen weapon
        Weapon weapon = this.inventory[chosenAttack-1];



        for(int i = 0; i < weapon.numAttacks; i++){

            

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

                String b = "Which Enemy do You Want to Hit?";
                int choice = GameLogic.readInt(b, encounter.enemies.length);
                Enemy target = encounter.enemies[choice - 1];

                target.hp -= weapon.damage;
                encounter.maxHp -= weapon.damage;
                }
            
            
        }
    }
}
