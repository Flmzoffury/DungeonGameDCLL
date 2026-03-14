public abstract class Treasure implements GameElement
{
    abstract public Object interact(Player inputPlayer);

    public String toString()
    {
        return "Treasure";
    }
}
