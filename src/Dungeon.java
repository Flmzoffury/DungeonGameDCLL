import java.util.Random;

public class Dungeon
{
    Random randomizer;
    SamDCLL<Room> rooms;
    int dungeonLength;
    boolean dungeonFinished;
    boolean gameLost;

    public Dungeon()
    {
        //Game Flags
        gameLost = false;
        dungeonFinished = false;

        //Randomizer Object
        randomizer = new Random();

        //DCLL of Rooms
        rooms = new SamDCLL<Room>();

        //Randomizer for dungeon size;
        dungeonLength = 8 + randomizer.nextInt(6);

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

    public void playerMoveLeft()
    {
        Node<Room> myPlayerRoom = this.findPlayer();
        Node<Room> myLeftRoom = myPlayerRoom.getPrevNode();

        if (myLeftRoom.getData().getObj() == null)
        {
            myLeftRoom.getData().setObj(myPlayerRoom.getData().getObj());
            myPlayerRoom.getData().setObj(null);
        }
        else if (myLeftRoom.getData().getObj() instanceof Exit)
        {
            dungeonFinished = true;
        }
        else if (myLeftRoom.getData().getObj() instanceof Monster)
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
        /*
        else if (myLeftRoom.getData().getObj() instanceof Treasure) @todo treasure interaction + removal
        {
        }
         */

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
        /*
        else if (myLeftRoom.getData().getObj() instanceof Treasure) @todo treasure interaction + removal
        {
        }
         */
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
