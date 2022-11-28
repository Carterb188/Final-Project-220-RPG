import java.util.Scanner;



class GameLogic{

    
    static int currentLevel = 0;
    
    
    //Create a Scanner Object
    static Scanner scanner = new Scanner(System.in);

    /* readInt() is a method with two arguemnts
        prompt - is a mesage prompt informing the usr of their choices
        usrChoices - is an int that represents the number of choices the user has
        
        readInt() will repeat until the user choices an avaliable choice
        readInt() will then return the choice as an int
    */
    public static int readInt(Encounter encounter, String prompt, int usrChoices){

        int input;
        System.out.println();
        combatDisplay(encounter);

        do{
            System.out.println(prompt);

            try{

                input = Integer.parseInt(scanner.next());

            }catch(Exception e){

                System.out.println("Please Enter an Integer");
                input = -1;
            }
            
        }while(input <= 0 || input > usrChoices);

        return input;
    }

    /* clearScreen() is a method with no arguments
    clearScreen() will print 99 line breaks to clear out what is currently
    on the screen
    */
    public static void clearScreen(){
        for(int i = 0; i < 100; i++){
            System.out.println();
        }
    }

    /* printSeperator is a method with one argument
    n - is an int parameter that represents how many '-' to print
    */
    public static void printSeperator(int n){
        for(int i = 0; i < n; i++){
            System.out.print("-+-");
        }
    }


    /* printHeading is a method with one argument
    heading - is an String parameter that represents the text to bre printed
    as a heading

    printHeading - will print out 30 '-' before and after the text
    */
    public static void printHeading(String heading){
        System.out.print('|');
        printSeperator(10);
        System.out.print(heading);
        printSeperator(10);
        System.out.print('|');
        System.out.println();

    }

    /* anythingToContinue - adds a pause to the game;*/
    public static void anythingToContinue(){
        System.out.println("\nHit any key to continue->>");
        scanner.next();
    }

    public static void combat(Encounter encounter){
        Boolean combat = true;
        boolean win = false;
        currentLevel +=1;
        int enemyChoice;

        do{
            //Setup
            clearScreen();
            combatDisplay(encounter);

            //Chose Weapon
            int weaponChoice = pickWeapon(encounter);
            if(!Main.player.inventory[weaponChoice].aoe){

                 //Chose Enemy if weapon is not aoe
                enemyChoice =  pickEnemy(encounter);
            }else{
                enemyChoice = 0;
            }
           
            //Player Attacks
            Main.player.attack(encounter, weaponChoice, enemyChoice);
            System.out.println(Encounter.encounter_1_1.maxHp);

            //Checks if Enemies are still alive to attack
            // if not, Ends combat, sets win to true
            if(checkEnemies(encounter)){
                for(Enemy enemy: encounter.enemies){
                    enemy.enemyAttack(Main.player);
                }
            }else{
                win = true;
                combat = false;
            }

            //Checks to see If we Lost
            if(!checkPlayer()){
                win = false;
                combat = false;
            }

        }while(combat);
        //Display final Hp of enemies and hero//
        combatDisplay(encounter);
        anythingToContinue();

        if(win){
            victoryResults();
        }else{
            youLose();
        }
    }

    public static int pickEnemy(Encounter encounter){
        
        int input;
        int index;
        boolean notInt = false;
        boolean outOfIndex = false;
        boolean isDead = false;
        System.out.println();

        do{
            combatDisplay(encounter);
            System.out.println("Which Enemy do you want to attack");

            if(notInt){
                System.out.println("Input Must Be Integer!");
            }else if(outOfIndex){
                System.out.println("That Enemy Does Not Exist!");
            }else if(isDead){
                System.out.println("Enemy is already Dead!");
            }

            notInt = false;
            outOfIndex = false;
            isDead = false;

            try{
                input = Integer.parseInt(scanner.next());
                index = input - 1;
            }catch(Exception e){
                notInt = true;
                input = -1;
                index = 0;
            }

            outOfIndex = input > encounter.enemies.length;

            if(!outOfIndex){
                isDead = encounter.enemies[index].hp <= 0;
            }
            
        }while(input <= 0 || outOfIndex || isDead);

        return input - 1;
    }

    public static Boolean checkEnemies(Encounter encounter){
        if(encounter.maxHp <= 0){
            return false;
        }else{
            return true;
        }
    }

    public static Boolean checkPlayer(){
        
        if(Main.player.hp <= 0){
            return false;
        }else{
            return true;
        }
    }

    public static void victoryResults(){
        Main.player.coin += 1;
        clearScreen();
        System.out.println("Battle Results:");
        lineBreak(4);
    
        System.out.println("You Found A Coin and Added it to Your Pouch");
        lineBreak(1);
        
        if(currentLevel == 1){
            System.out.println("Save These for Later for Special Items!");
        }
        lineBreak(13);
            
        
        
        Main.player.hp = Main.player.maxHp;
        anythingToContinue();
        


    }

    public static void youLose(){
        
        System.out.println("\n\n\n");
        printHeading("YOU DIED");
        System.out.println("\n\n\n");
        printHeading("Your Parents are Disapointed in you Player...");
        System.out.println("\n\n\n");
        anythingToContinue();
    }

    
    /*
     * displayEnemyHp will display a message if informing the player
     * what hp each enemy is at.
     * if the enemy hp <= 0, the game will display the character is dead
     */
    public static void displayEnemyHp(Encounter encounter){

        //Display Enemy HP
        String enemyHealthOutline = "Enemy %d is at %dhp";
        String enemyDeadOutline = "Enemy %d is dead x_x";
        String enemyStatus = "";
        for(int i = 0; i < encounter.enemies.length; i++){
            if(encounter.enemies[i].hp > 0){
                enemyStatus = String.format(enemyHealthOutline, i+1, encounter.enemies[i].hp);
            }else{
                enemyStatus = String.format(enemyDeadOutline, i+1);
            }
             System.out.println(enemyStatus);
         }
    }



    /*
     * displayPlayerHp will display "You are at %dhp\n", where %d is
     * an integer value equaling the players hp
     */
    public static void displayPlayerHp(){
         //Display Player HP
         String playerHealthOutline = String.format("Player Hp: %dhp\n", Main.player.hp);
         System.out.println(playerHealthOutline);
    }



    /*pickWeapon() prints out weapon choices
     * if the choice is not an int, pickWeapons() returns -2;
     * if the choice is not an option, it will return the false index regardless
     * if the choice is an option it will return that index
     */
    public static int pickWeapon(Encounter encounter){
        int input;
        boolean outOfIndex = false;
        boolean notInt = false;
        System.out.println();
        
        do{
            combatDisplay(encounter);

            if(outOfIndex){
                System.out.println("Weapon Does Not Exist");
            }else if(notInt){
                System.out.println("Input Must Be Integer");
            }

            outOfIndex = false;
            notInt = false;

            try{
                input = Integer.parseInt(scanner.next());

                if(Main.player.inventory[input - 1].locked){
                    outOfIndex = true;
                }

                 
                if(input > Main.player.inventory.length|| (input - 1) < 0){
                    outOfIndex = true;
                }
    
            }catch(Exception e){
                System.out.println("Please Enter an Integer");
                notInt = true;
                input = -1;
            }

           
        }while(outOfIndex || notInt);

        return input - 1;
    }


    /*
     * combatDisplay() displays turn of combat
     * this information includes:
     * -Each enemies Hp
     * -Player Hp
     * -Weapon Options
     */
    public static void combatDisplay(Encounter encounter){
        clearScreen();
        displayPlayerHp();
        System.out.println();
        displayEnemyHp(encounter);
        System.out.println("\n");
        

        System.out.println("Inventory:");
        String a = "Attacks: \n(1)Sword\n(2)Dagger\n(3)Boomerang\n(4)Greek Fire\n(5)Dev Nuke\n";
        System.out.println(a);
        System.out.println();   

    }


    public static void lineBreak(int n){
        for(int i = 0; i < n; i++){
            System.out.println();
        }
    }

}