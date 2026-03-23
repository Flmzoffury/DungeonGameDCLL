import java.util.Scanner;
import java.util.Random;

public class GameControl
{
    private String playerInput;
    private String playerName;

    private Scanner textInput;

    private Random randGen;

    private Dungeon dungeon;

    private int floorCount;

    public GameControl()
    {
        textInput = new Scanner(System.in);
        randGen = new Random();
        floorCount = 0;
    }

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

    public void getPlayerName()
    {
        System.out.println("Name your Character: ");
        playerName = textInput.nextLine();
    }

    public void printDungeon()
    {
        dungeon.print();
    }

    public boolean getFinished()
    {
        return dungeon.getFinished();
    }

    public boolean getLost()
    {
        return dungeon.getLost();
    }

    public boolean getPlayerContinue()
    {
        System.out.println("Floor completed! Continue? Y/N");
        playerInput = textInput.nextLine().toUpperCase();
        return playerInput.equals("Y");
    }
}
