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
    public static int readInt(String prompt, int usrChoices){

        int input;
        System.out.println();

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
        boolean win = false;

        do{
            //Setup
            anythingToContinue();
            clearScreen();


            //Display Player HP
            String playerHealth = String.format("Your hp is %d\n", Main.player.hp);
            System.out.println(playerHealth);

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


            //Player Attacks
            Main.player.attack(encounter);


            //Checks if Enemies are still alive to attack
            if(checkEnemies(encounter)){
                for(Enemy enemy: encounter.enemies){
                    enemy.enemyAttack(Main.player);
                }
            }else{
                win = true;
                combat = false;
            }

            //Checks to see If we Lost
            if(checkPlayer()){
                win = false;
                combat = false;
                Main.player.hp = Main.player.maxHp;
            }
        }while(combat);
        
        if(win){
            victoryResults();
        }else{
            youLose();
        }
        
    }

    public static Boolean checkEnemies(Encounter encounter){
        if(encounter.maxHp <= 0){
            return false;
        }else{
            return true;
        }
    }

    public static Boolean checkPlayer(){
        if(Main.player.maxHp <= 0){
            return false;
        }else{
            return true;
        }
    }

    public static void victoryResults(){
        Main.player.coin += 1;
        System.out.println("\nBattle Results:");
    
        
        if(currentLevel == 1){
            System.out.println("You Found a coin!");
            System.out.println("Save These for Later for Special Items!");
            System.out.println("Hit Enter to Continue-->>");
            anythingToContinue();
        }else{
            System.out.println("+1 Coin");
            System.out.println("Hit Enter to Continue-->>");
        }
        
        anythingToContinue();
        


    }

    public static void youLose(){
        
        System.out.println("\n\n\n");
        printHeading("YOU DIED");
        System.out.println("\n\n\n");
        printHeading("Your Parents are Disapointed in you Player...");
        System.out.println("\n\n\n");
    }

    


}