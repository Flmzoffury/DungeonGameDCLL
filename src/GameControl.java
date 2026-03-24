import java.util.Scanner;
import java.util.Random;

/**
 * Class to handle events in the gameplay loopp
 */
public class GameControl
{
    /**
     * The current input by the player
     */
    private String playerInput;
    /**
     * Theh name of the player
     */
    private String playerName;
    /**
     * Scanner to read player input
     */
    private Scanner textInput;
    /**
     * RNG
     */
    private Random randGen;
    /**
     * The dungeon in the game
     */
    private Dungeon dungeon;
    /**
     * The number of completed floors
     */
    private int floorCount;

    /**
     * Initializes textInput, randGen, and floorCount
     */
    public GameControl()
    {
        textInput = new Scanner(System.in);
        randGen = new Random();
        floorCount = 0;
    }

    /**
     * Generates the dungeon
     */
    public void genDungeon()
    {
        dungeon = new Dungeon(floorCount);
        dungeon.insert(new Player(playerName));
        dungeon.insert(new Exit());

        int randRoomType;

        for (int i = 0; i < ((dungeon.getLength() - 2) / 2); i++) {
            randRoomType = randGen.nextInt(3);
            if (randRoomType == 0) {
                dungeon.insertMonster();
            }
            else if (randRoomType == 1) {
                dungeon.insertTreasure();
            }
        }
    }

    /**
     * Takes player input for the main actions
     */
    public void takePlayerInput()
    {
        System.out.println("\nWhat do you want to do? Type H for help.");

        playerInput = textInput.nextLine().toUpperCase();

        if (playerInput.equals("H"))
        {
            System.out.println("Possible Actions:\nType \"L\" to move left on the floor.\nType \"R\" to move right on the floor.");
            System.out.println("Type STATS to see your stats.");
        }
        else if (playerInput.equals("L"))
        {
            dungeon.playerMoveLeft();
        }
        else if (playerInput.equals("R"))
        {
            dungeon.playerMoveRight();
        }
        else if (playerInput.equals("STATS"))
        {
            dungeon.printPlayerStats();
        }
    }

    /**
     * Prompts the player to type in a name
     */
    public void getPlayerName()
    {
        System.out.println("Name your Character: ");
        playerName = textInput.nextLine();
    }

    /**
     * Prints out the dungeon
     */
    public void printDungeon()
    {
        dungeon.print();
    }

    /**
     * Returns if the dungeon is finished or not
     * @return dungeon.getFinished()
     */
    public boolean getFinished()
    {
        return dungeon.getFinished();
    }

    /**
     * Returns if the dungeon has been lost or not
     * @return dungeon.getLost()
     */
    public boolean getLost()
    {
        return dungeon.getLost();
    }

    /**
     * Prompts the player to continue or not
     * @return if the player wants to continue or not
     */
    public boolean getPlayerContinue()
    {
        System.out.println("Floor completed! Continue? Y/N");
        playerInput = textInput.nextLine().toUpperCase();
        return playerInput.equals("Y");
    }
}
