import java.util.Scanner;
import java.io.File;  // Import the File class



class GameLogic{

    
    static int currentLevel = 0;
    static Boolean alive = true;
    
    
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
        currentLevel +=1;
        

        do{
            //Setup
            clearScreen();

            //Chose Weapon
            int weaponChoice = pickWeapon(encounter);
           
            //Player Attacks
            Main.player.attack(encounter, weaponChoice);

            //Checks if Enemies are still alive to attack
            // if not, Ends combat, sets win to true
            if(checkEnemies(encounter)){
                for(Enemy enemy: encounter.enemies){
                    if(enemy.hp > 0){
                        enemy.enemyAttack(Main.player);
                    }
                    
                }
            }else{
                alive = true;
                combat = false;
            }

            //Checks to see If we Lost
            if(!checkPlayer()){
                alive = false;
                combat = false;
            }

        }while(combat);
        //Display final Hp of enemies and hero//
        combatDisplay(encounter);
        anythingToContinue();

        if(!alive){
            youLose();
        }else{
            Main.player.hp = Main.player.maxHp;
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


    public static void youLose(){
        
        String s = "You Have Perished, Only A Miracule Can Save Your Family Now\n\n\n\n";
        String s2 = "***********GAMEOVER*************";
        System.out.println(s);
        System.out.println(s2);
        anythingToContinue();
    }

    
    /*
     * displayEnemyHp will display a message if informing the player
     * what hp each enemy is at.
     * if the enemy hp <= 0, the game will display the character is dead
     */
    public static void displayEnemyHp(Encounter encounter){

        //Display Enemy HP
        String enemyHealthOutline = " #%d is at %dhp";
        String enemyDeadOutline = " #%d is dead x_x";
        String enemyHealth;
        String enemyName = "";
        String enemyStatus = "";
        for(int i = 0; i < encounter.enemies.length; i++){
            enemyName = encounter.enemies[i].name;
            if(encounter.enemies[i].hp > 0){
                enemyHealth = String.format(enemyHealthOutline, i+1, encounter.enemies[i].hp);
                enemyStatus = enemyName + enemyHealth;
            }else{
                enemyHealth = String.format(enemyDeadOutline, i+1);
                enemyStatus = enemyName + enemyHealth;
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
        int weaponNum = 0;
        

        

        for(Weapon weapon: Main.player.inventory){
            if(!weapon.locked){
                weaponNum++;
            }
        }

        do{

            combatDisplay(encounter);
            System.out.println("Which Weapon Do You Want to Attack With?");

            if(outOfIndex){
                System.out.println("Weapon Does Not Exist");
            }else if(notInt){
                System.out.println("Input Must Be Integer");
            }

            outOfIndex = false;
            notInt = false;
            if(weaponNum > 1){
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
    
                
            }else{
                input = 1;
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
        String a = getWeaponString();
        System.out.println(a);
        System.out.println();   

    }


    public static void lineBreak(int n){
        for(int i = 0; i < n; i++){
            System.out.println();
        }
    }

    /*printPrompt() - takes a String representing a file name
    *printPromt() reads through each line and prints it if it is not soley set keywords
    * 
    *Key Words:
    *Padding - adds linebreaks in 
    */
    
    public static void printPrompt(String fileString){
        int padding = 8;

        File file = new File(fileString);
        try{
            Scanner fileScanner = new Scanner(file);
            boolean read = true;
            String s;
            while(read){
                s = fileScanner.nextLine();
                if(s.equals("STOP")){
                    read = false;
                    fileScanner.close();
                }else if(s.equals("PAUSE")){
                    anythingToContinue();
                }else if(s.equals("CLEAR")){
                    clearScreen();
                }else if(s.equals("PADDING")){
                    for(int i = 0; i < padding; i++)
                    System.out.println();
                }else{
                    System.out.println(s);
                }
            }
        }catch(Exception e){
            System.out.println("File Not Found");
        }
       
    }

    public static String getWeaponString(){
        Weapon[] inventory = Main.player.inventory;
        String list = "";
        for(int i = 0; i < inventory.length; i++){
            if(!inventory[i].locked){
                String s = "(%d)"+inventory[i].name+"\n";
                list += String.format(s, i+1);
            }
        }
        return list;
    }

}