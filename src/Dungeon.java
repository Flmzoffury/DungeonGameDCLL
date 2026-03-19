import java.util.Random;

/**
 * The class contains a Doubly Circularly Linked List representing the rooms of the circular dungeon.
 */
public class Dungeon
{
    /**
     * Randomizer used for rng
     */
    private Random randomizer;
    /**
     * DCLL representing dungeon
     */
    private SamDCLL<Room> rooms;

    /**
     * The # of rooms in the dungeon
     */
    private int dungeonLength;
    /**
     * The level of the dungeon
     */
    private int dungeonLevel;

    /**
     * Flag representing if the dungeon has been completed
     */
    private boolean dungeonFinished;
    /**
     * Flag representing if the player has lost all health
     */
    private boolean gameLost;

    /**
     * Constructor for the dungeon creates all rooms in the dungeon
     * @param inputLevel Decides the level of the dungeon
     */
    public Dungeon(int inputLevel)
    {
        //Game Flags
        gameLost = false;
        dungeonFinished = false;

        //Randomizer Object
        randomizer = new Random();

        //DCLL of Rooms
        rooms = new SamDCLL<Room>();

        //Assign Level
        dungeonLevel = inputLevel;

        //Randomizer for dungeon size;
        dungeonLength = 8 + randomizer.nextInt(6) + dungeonLevel;

        for (int i = 0; i < dungeonLength; i++)
        {
            Room temp = new Room(null);
            rooms.add(temp);
        }
    }

    /**
     * Prints all rooms of the dungeon and their contents
     */
    public void print()
    {
        rooms.print();
    }

    /**
     * Returns the dungeon length
     * @return The number of rooms in the dungeon
     */
    public int getLength()
    {
        return dungeonLength;
    }

    /**
     * Inserts a object into a random dungeon room not already containing an object
     * @param inputObject The object to be inserted into the dungeon room
     */
    public void insert(Object inputObject) //Note: this breaks when trying to insert objects when no rooms are available
    {
        boolean inserted = false;
        Node<Room> tempRoom = rooms.getHead();

        while (!inserted)
        {
            if (randomizer.nextInt(100) == 0)
            {
                if (tempRoom.getData().getObj() == null)
                {
                    tempRoom.getData().setObj(inputObject);
                    inserted = true;
                }
            }
            else
            {
                tempRoom = tempRoom.getNextNode();
            }
        }
    }

    /**
     * Inserts a random monster type
     */
    public void insertMonster()
    {
         Monster inputMonster;
         int randMon = randomizer.nextInt(4);

         if (randMon == 0)
         {
             inputMonster = new OrcGrunt(dungeonLevel);
         }
         else if (randMon == 1)
         {
             inputMonster = new OrcRaider(dungeonLevel);
         }
         else if (randMon == 2)
         {
             inputMonster = new OrcSorcerer(dungeonLevel);
         }
         else
         {
             inputMonster = new OrcBrute(dungeonLevel);
         }

         this.insert(inputMonster);
    }

    /**
     * Inserts a random treasure type with random stats
     */
    public void insertTreasure()
    {
        Treasure inputTreasure;
        int randTre = randomizer.nextInt(4);

        if (randTre == 0)
        {
            inputTreasure = new Trap((randomizer.nextInt(3)+dungeonLevel+1)*5);
        }
        else if (randTre == 1 || randTre == 2)
        {
            inputTreasure = new Potion((randomizer.nextInt(3)+dungeonLevel+1)*10);
        }
        else
        {
            int randType = randomizer.nextInt(3);
            String equipName;

            if (randType == 0)
            {
                equipName = "Gauntlet";
            }
            else if (randType == 1)
            {
                equipName = "Blade";
            }
            else if (randType == 2)
            {
                equipName = "Charm";
            }

            inputTreasure = new Equipment((randomizer.nextInt(3)+dungeonLevel+1)*5,(randomizer.nextInt(3)+dungeonLevel+1)*5,"Sword");
        }

        insert(inputTreasure);
    }

    /**
     * Checks the room to the left of the player and interacts with it
     */
    public void playerMoveLeft()
    {
        Node<Room> myPlayerRoom = this.findPlayer();
        Node<Room> myLeftRoom = myPlayerRoom.getPrevNode();

        if (myLeftRoom.getData().getObj() == null) //Interact with empty room
        {
            myLeftRoom.getData().setObj(myPlayerRoom.getData().getObj());
            myPlayerRoom.getData().setObj(null);
        }
        else if (myLeftRoom.getData().getObj() instanceof Exit) //Interact with exit
        {
            dungeonFinished = true;
        }
        else if (myLeftRoom.getData().getObj() instanceof Monster) //Interact with monster
        {
            Player myPlayer = (Player) myPlayerRoom.getData().getObj();
            Monster myMonster = (Monster) myLeftRoom.getData().getObj();
            myPlayer.fight(myMonster);
            if (!myMonster.getAlive())
            {
                rooms.removeNode(myLeftRoom);
                dungeonLength--;
            }
            else if (!myPlayer.getAlive())
            {
                gameLost = true;
            }
        }
        else if (myLeftRoom.getData().getObj() instanceof Treasure) //Interact with treasure
        {
            Player myPlayer = (Player) myPlayerRoom.getData().getObj();
            Treasure myTreasure = (Treasure) myLeftRoom.getData().getObj();

            myTreasure.interact(myPlayer);

            myPlayerRoom.getData().setObj(null);
            myLeftRoom.getData().setObj(myPlayer);
        }

    }

    /**
     * Checks the room to the right of the player and interacts with it
     */
    public void playerMoveRight()
    {
        Node<Room> myPlayerRoom = this.findPlayer();
        Node<Room> myRightRoom = myPlayerRoom.getNextNode();

        if (myRightRoom.getData().getObj() == null)
        {
            myRightRoom.getData().setObj(myPlayerRoom.getData().getObj());
            myPlayerRoom.getData().setObj(null);
        }
        else if (myRightRoom.getData().getObj() instanceof Exit)
        {
            dungeonFinished = true;
        }
        else if (myRightRoom.getData().getObj() instanceof Monster)
        {
            Player myPlayer = (Player) myPlayerRoom.getData().getObj();
            Monster myMonster = (Monster) myRightRoom.getData().getObj();
            myPlayer.fight(myMonster);
            if (!myMonster.getAlive())
            {
                rooms.removeNode(myRightRoom);
                dungeonLength--;
            }
        }
        else if (myRightRoom.getData().getObj() instanceof Treasure)
        {
            Player myPlayer = (Player) myPlayerRoom.getData().getObj();
            Treasure myTreasure = (Treasure) myRightRoom.getData().getObj();

            myTreasure.interact(myPlayer);

            myPlayerRoom.getData().setObj(null);
            myRightRoom.getData().setObj(myPlayer);
        }

    }

    /**
     * Finds the Node containing the room containing the player
     * @return The Node<Room> containing the player
     */
    private Node<Room> findPlayer()
    {
        Node<Room> tempNode = rooms.getHead();
        while (!(tempNode.getData().getObj() instanceof Player))
        {
            tempNode = tempNode.getNextNode();
        }
        return tempNode;
    }

    /**
     * Returns the dungeonFinished flag
     * @return If the dungeon is finished
     */
    public boolean getFinished()
    {
        return dungeonFinished;
    }

    /**
     * Returns the gameLost flag
     * @return If the dungeon is lost
     */
    public boolean getLost()
    {
        return gameLost;
    }

    /**
     * Prints the Player's stats
     */
    public void printPlayerStats()
    {
        Object myPlayer = this.findPlayer().getData().getObj();
        if (myPlayer instanceof Player)
        {
            Player tempPlayer = (Player) myPlayer;
            tempPlayer.printStats();
        }
    }
}
