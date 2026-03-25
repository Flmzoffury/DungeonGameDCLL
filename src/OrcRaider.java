/**
 * Premade monster that constructs based on its level
 */
public class OrcRaider extends Monster
{
    /**
     * Constructs using the super() with values based on level
     * @param level
     */
    public OrcRaider(int level)
    {
        super(80 + 5*level, 10+5*((int) level/2), 8 + level,"Orc Raider");
    }
}
