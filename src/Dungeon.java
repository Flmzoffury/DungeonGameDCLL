import java.util.Random;

public class Dungeon
{
    private Random randomizer;
    private SamDCLL<Room> rooms;

    private int dungeonLength;
    private int dungeonLevel;

    private boolean dungeonFinished;
    private boolean gameLost;

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

    public void print()
    {
        rooms.print();
    }

    public int getLength()
    {
        return dungeonLength;
    }

    /**
     * Inserts a object into a random dungeon room
     * @param inputObject The object to be inserted into the dungeon room
     */
    public void insert(Object inputObject)
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
     * Inserts a random monster
     */
    public void insertMonster()
    {
         Monster inputMonster;
         int randMon = randomizer.nextInt(4);

         if (randMon == 0)
         {
             inputMonster = new OrcGrunt();
         }
         else if (randMon == 1)
         {
             inputMonster = new OrcRaider();
         }
         else if (randMon == 2)
         {
             inputMonster = new OrcSorcerer();
         }
         else
         {
             inputMonster = new OrcBrute();
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

    private Node<Room> findPlayer()
    {
        Node<Room> tempNode = rooms.getHead();
        while (!(tempNode.getData().getObj() instanceof Player))
        {
            tempNode = tempNode.getNextNode();
        }
        return tempNode;
    }

    public boolean getFinished()
    {
        return dungeonFinished;
    }

    public boolean getLost()
    {
        return gameLost;
    }

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
