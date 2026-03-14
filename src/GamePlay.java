import java.util.Scanner;
import java.util.Random;

/*
 this project was created with one Tyler, Pokemon
 */

/**
 * This class contains the core gameplay loop of the circular dungeon-crawler game
 */
public class GamePlay
{
    /**
     * static method to play the dungeon-crawler
     * @param args
     */
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

        //Floor Counter
        int floorCount = 0;

        //Dungeon
        Dungeon myDungeon = new Dungeon(0);

        //Primary Gameloop
        while (inGame) {

            //Set-up for new dungeon
            if (setupPhase == true) {

                myDungeon = new Dungeon(floorCount);
                myDungeon.insert(new Exit());
                myDungeon.insert(new Player(charName));

                int randRoomType;

                for (int i = 0; i < ((myDungeon.getLength() - 2) / 2); i++) {
                    randRoomType = randomizer.nextInt(3);
                    if (randRoomType == 0) {
                        myDungeon.insertMonster();
                    }
                    else if (randRoomType == 1) {
                        myDungeon.insertTreasure();
                    }
                }

                setupPhase = false;
            }

            //Seperate Text from Each Loop
            System.out.println("_______________________________________________________");

            //Dungeon display
            myDungeon.print();

            //Player input
            System.out.println("\nWhat do you want to do? Type H for help.");
            playerAction = inputReader.nextLine().toUpperCase();

            //Player actions
            if (playerAction.equals("H"))
            {
                System.out.println("Possible Actions:\nType \"L\" to move left on the floor.\nType \"R\" to move right on the floor.");
                System.out.println("Type STATS to see your stats.");
            }
            else if (playerAction.equals("L"))
            {
                myDungeon.playerMoveLeft();
            }
            else if (playerAction.equals("R"))
            {
                myDungeon.playerMoveRight();
            }
            else if (playerAction.equals("STATS"))
            {
                myDungeon.printPlayerStats();
            }

            //Dungeon Flag Checks
            if (myDungeon.getFinished())
            {
                floorCount++;
                System.out.println("Floor completed! Continue? Y/N");
                playerAction = inputReader.nextLine().toUpperCase();
                if (playerAction.equals("Y"))
                {
                    setupPhase = true;
                }
                else
                {
                    inGame = false;
                }
            }
            else if (myDungeon.getLost())
            {
                System.out.println("You have lost! Game over.");
                inGame = false;
            }

        }

        //Game End
        System.out.println("Thank you for playing!");
        System.out.println("You completed " + floorCount + " floors!");

    }
}
