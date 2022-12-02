class Main
{
    public static Player player = new Player("James", 10);

    public static void main(String[] args){

        //Title Screen
        GameLogic.clearScreen();
        String title = "                _______           _______             \n      |\\     /|(  ___  )|\\     /|(  ____ )            \n      | )   ( || (   ) || )   ( || (    )|            \n      | (___) || |   | || |   | || (____)|            \n      |  ___  || |   | || |   | ||     __)            \n      | (   ) || |   | || |   | || (\\ (               \n      | )   ( || (___) || (___) || ) \\ \\__            \n      |/     \\|(_______)(_______)|/   \\__/            \n                                                      \n                  _______  _______                    \n                 (  ___  )(  ____ \\                   \n                 \\ (   ) /| (    \\/                   \n         _____    \\ \\ / / | (__       _____           \n        (_____)    )   (  |  __)     (_____)          \n                  / / \\ \\ | (                         \n                 / (___) \\| )                         \n                (________)|/                          \n                                                      \n _______  _______ _________ _______ _________ _______ \n(  ____ \\(  ____ )\\__   __/(  ____ \\\\__   __/(  ____ \\\n| (    \\/| (    )|   ) (   | (    \\/   ) (   | (    \\/\n| |      | (____)|   | |   | (_____    | |   | (_____ \n| |      |     __)   | |   (_____  )   | |   (_____  )\n| |      | (\\ (      | |         ) |   | |         ) |\n| (____/\\| ) \\ \\_____) (___/\\____) |___) (___/\\____) |\n(_______/|/   \\__/\\_______/\\_______)\\_______/\\_______)\n                                                      ";
        ps(title);
        GameLogic.anythingToContinue();
    
        //Prints Out Story Prompt
        GameLogic.printPrompt("Story_Prompts.txt");


        //Encounter #1
        GameLogic.clearScreen();
        String s1 = "On the road...\nA Pack Of Wolves See You as Easy Prey and Rushes You!\nPrepare Yourself\n";
        System.out.println(s1);
        GameLogic.anythingToContinue();
        GameLogic.combat(Encounter.encounter_1);
        if(GameLogic.alive){
            GameLogic.clearScreen();
            String r1 = "\n\nYou have defeated the Wolf Pack!!!\n\nLodged in one of the Wolves you find a Hunting Knife and put it in your Pocket\n\nLoka has healed You to full health";
            String knifeInstr = "\n\n\n\n\n\nGame Tip: With the Kife You Can Make 2 Attacks Per Turn\n\n\n";
            player.inventory[1].locked = false;
            ps(r1);
            ps(knifeInstr);
            GameLogic.anythingToContinue();
        }
        
        if(GameLogic.alive){
            //Encounter #2
            GameLogic.clearScreen();
            String s2 = "After defeating the wolves and going on your way...\nA Troll blocks your way and tries to eat you\nPrepare Yourself\n";
            ps(s2);
            GameLogic.anythingToContinue();
            GameLogic.combat(Encounter.encounter_2);
        }
        if(GameLogic.alive){
            String r2 = "\n\nThe Troll has fallen by your hand Adventurer!!!!\n\nLoka has Magically Heals You for Your next Battle\n\nRush foward Troll Slayer!!!";
            ps(r2);
            GameLogic.anythingToContinue();

        }
        
        //Encounter #3
        if(GameLogic.alive){
            GameLogic.clearScreen();
            String s3 = "The Troll has fallen, you continue Onward and Arrive just Outside the Village\nYou are seen by the Enemy who rushes You down\nPrepare Yourself";
            ps(s3);
            GameLogic.anythingToContinue();
            GameLogic.combat(Encounter.encounter_3);
        }
        if(GameLogic.alive){
            String r3 = "The First Wave falls by your hands, but not without notice.....\n\n The Remaining Knolls Turn their Attention to you";
            String r4 = "Before they Could get within Distance you Notice a Shining Glass Bottle on one of the defeated Knoll Bodies";
            String r5 = "You Pocket a Magic Flask of Greek Fire\n\n\n";
            String r6 = "Tip!: Greek Fire Does Damage to Everyone, Even You!";
            Weapon.greekFire.locked = false;
            ps(r3);
            GameLogic.anythingToContinue();
            GameLogic.clearScreen();
            ps(r4);
            ps(r5);
            ps(r6);
            GameLogic.anythingToContinue();
        }



        //Encounter #4
        if(GameLogic.alive){
            GameLogic.clearScreen();
            String s4 = "You are Surounded by the Knolls, Pepare Yourself!";
            ps(s4);
            GameLogic.combat(Encounter.encounter_4);
        }
        if(GameLogic.alive){
            GameLogic.clearScreen();
            String r7 = "The Knolls Fall From the Burns Inflicted Your Quick Thinking";
            String r8 = "This is Not Over Yet!\n\n";
            String r9 = "You have now Angered the Monarch and His Executioner\n\n";
            String r10 = "Loka: Im giving You All I have, Now Win!!!!!";
            String r11 = "You gained +5 Hp and are fully healed";
            player.hp += 5;
            ps(r7);
            ps(r8);
            ps(r9);
            ps(r10);
            ps(r11);
            GameLogic.anythingToContinue();
        }
        if(GameLogic.alive){
            String s5 = "The Monarch and His Executioner Aproaches, Perpare Yourself";
            ps(s5);
            GameLogic.combat(Encounter.encounter_5);
        }
        if(GameLogic.alive){
            String f1 = "You stand tall while the great army that once was lies still";
            String f2 = "The Village, Your Family, And Your Freinds are safe now\n\n\n";
            String f3 = "As the adrinaline fades, youre body sucumbs to the fatigue...";
            String f4 = "Rest Hero You've Earned it, The Hour of Crisis has Passed......";
            String f5 = "Fin";
            ps(f1);
            ps(f2);
            ps(f3);
            ps(f4);
            ps(f5);
            GameLogic.anythingToContinue();
        }

        



    }

    public static void ps (String s){
        System.out.println(s);
    }
}