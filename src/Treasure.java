/**
 * Abstract class for the types of Treasures that can be seen within the dungeon
 */
public abstract class Treasure implements GameElement
{
    /**
     * Abstract method requiring a treasure to be able to interact with a Player object
     * @param inputPlayer the player that is interacting with the Treasure
     * @return
     */
    abstract public Object interact(Player inputPlayer);

    /**
     * toString so a Treasure object is displayed as "Treasure"
     * @return "Treasure"
     */
    public String toString()
    {
        return "Treasure";
    }
}
