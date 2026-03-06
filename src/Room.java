public class Room
{
    private Object obj;

    public Room(Object inputObject)
    {
        obj = inputObject;
    }

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

    public void setObj(Object inputObject)
    {
        obj = inputObject;
    }

    public Object getObj()
    {
        return obj;
    }
}
