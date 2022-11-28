class Main
{
    public static Player player = new Player("James", 10);

    public static void main(String[] args){
        GameLogic.clearScreen();
        String title = "                _______           _______             \n      |\\     /|(  ___  )|\\     /|(  ____ )            \n      | )   ( || (   ) || )   ( || (    )|            \n      | (___) || |   | || |   | || (____)|            \n      |  ___  || |   | || |   | ||     __)            \n      | (   ) || |   | || |   | || (\\ (               \n      | )   ( || (___) || (___) || ) \\ \\__            \n      |/     \\|(_______)(_______)|/   \\__/            \n                                                      \n                  _______  _______                    \n                 (  ___  )(  ____ \\                   \n                 \\ (   ) /| (    \\/                   \n         _____    \\ \\ / / | (__       _____           \n        (_____)    )   (  |  __)     (_____)          \n                  / / \\ \\ | (                         \n                 / (___) \\| )                         \n                (________)|/                          \n                                                      \n _______  _______ _________ _______ _________ _______ \n(  ____ \\(  ____ )\\__   __/(  ____ \\\\__   __/(  ____ \\\n| (    \\/| (    )|   ) (   | (    \\/   ) (   | (    \\/\n| |      | (____)|   | |   | (_____    | |   | (_____ \n| |      |     __)   | |   (_____  )   | |   (_____  )\n| |      | (\\ (      | |         ) |   | |         ) |\n| (____/\\| ) \\ \\_____) (___/\\____) |___) (___/\\____) |\n(_______/|/   \\__/\\_______/\\_______)\\_______/\\_______)\n                                                      ";
        System.out.println(title);
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