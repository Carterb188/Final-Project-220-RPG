class Main
{
    public static Player player = new Player("James", 10);

    public static void main(String[] args){
        GameLogic.clearScreen();
        String title = "=<|Dungeon Delvers|>=";
        GameLogic.printHeading(title);
        GameLogic.anythingToContinue();

        GameLogic.clearScreen();
        String scene1 = "You are rushed by 3 hideous goblins";
        String scene1sub = "+--+--+--+-=<|Fight!|>=+--+--+--+";
        GameLogic.printHeading(scene1);
        GameLogic.printHeading(scene1sub);
        System.out.println("\n");


        GameLogic.combat(Encounter.encounter_1_1);



        GameLogic.clearScreen();
        String scene2 = "You are rushed by a Violent Orc!";
        String scene2sub = "+--+--+--+-=<|Slay!|>=+--+--+--+";
        GameLogic.printHeading(scene2);
        GameLogic.printHeading(scene2sub);
        System.out.println("\n");

        GameLogic.combat(Encounter.encounter_2_1);
        

        



    }
}