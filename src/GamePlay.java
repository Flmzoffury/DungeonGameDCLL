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
        GameControl myGame = new GameControl();

        //Initial Flags
        boolean inGame = true;
        boolean setupPhase = true;

        //Set-up Player
        myGame.getPlayerName();

        //Floor Counter
        int floorCount = 0;

        //Primary Gameloop
        while (inGame) {

            //Set-up for new dungeon
            if (setupPhase)
            {
                myGame.genDungeon();
                setupPhase = false;
            }

            //Dungeon display
            System.out.println("_______________________________________________________");
            myGame.printDungeon();

            //Player input
            System.out.println("_______________________________________________________");
            myGame.takePlayerInput();

            //Dungeon Flag Checks
            if (myGame.getFinished())
            {
                floorCount++;
                if (myGame.getPlayerContinue())
                {
                    setupPhase = true;
                }
                else
                {
                    inGame = false;
                }
            }
            else if (myGame.getLost())
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
