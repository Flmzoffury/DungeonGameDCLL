import java.util.Scanner;
import java.util.Random;

/*
 this project was created with one Tyler, Pokemon
 */


public class GamePlay
{
    public static void main(String[] args)
    {
        //Initial Flags
        boolean inGame = true;
        boolean setupPhase = true;

        //Accessing Import Classes
        Random randomizer = new Random();
        Scanner inputReader = new Scanner(System.in);

        //User Setup
        System.out.println("Enter Your Character's Name: ");
        String charName = inputReader.nextLine();

        //Player Event Input Handle
        String playerAction;

        //Primary Gameloop
        while (inGame) {
            if (setupPhase == true) {
                Dungeon myDungeon = new Dungeon();

                myDungeon.insert(new Exit());
                myDungeon.insert(new Player(charName));

                int randRoomType;

                for (int i = 0; i < ((myDungeon.getLength() - 2) / 2); i++) {
                    randRoomType = randomizer.nextInt(3);
                    if (randRoomType == 0) {
                        myDungeon.insertMonster();
                    } else if (randRoomType == 1) {
                        //myDungeon.insert(new Treasure());
                    }
                }

                myDungeon.print();
                setupPhase = false;
            }

            //Player input

            System.out.println("\nWhat do you want to do? Type H for help.");
            playerAction = inputReader.nextLine().toUpperCase();

            if (playerAction.equals("H"))
            {
                System.out.println("Possible Actions:\nType \"L\" to move left on the floor.\nType \"R\" to move right on the floor.");
            }
            else if (playerAction.equals("L"))
            {

            }
            else if (playerAction.equals("R"))
            {

            }
        }
    }
}
