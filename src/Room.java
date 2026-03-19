/**
 * A room in the dungeon that stores what is within the dungeon
 */
public class Room
{
    /**
     * The object that is "in" the room
     */
    private Object obj;

    /**
     * Constructor assigns the object within the room
     * @param inputObject The object that is stored within the room
     */
    public Room(Object inputObject)
    {
        obj = inputObject;
    }

    /**
     * Standard toString implementation
     * @return Returns the name of the object stored in the room, alongside standard formatting.
     */
    public String toString()
    {
        if (obj == null)
        {
            return "[   ]";
        }
        else
        {
            return "[" + obj.toString() + "]";
        }
    }

    /**
     * Assigns the object within the room
     * @param inputObject The object to be placed within the room
     */
    public void setObj(Object inputObject)
    {
        obj = inputObject;
    }

    /**
     * Gets the object inside the room
     * @return The object inside the room
     */
    public Object getObj()
    {
        return obj;
    }
}
