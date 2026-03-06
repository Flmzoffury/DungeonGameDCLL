import java.util.Random;

public class Dungeon
{
    Random randomizer;
    SamDCLL<Room> rooms;
    int dungeonLength;

    public Dungeon()
    {
        randomizer = new Random();

        rooms = new SamDCLL<Room>();

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
}
