/**
 * Premade monster that constructs based on its level
 */
public class OrcSorcerer extends Monster
{
    /**
     * Constructs using the super() with values based on level
     * @param level
     */
    public OrcSorcerer(int level)
    {
        super(200 + 5*level, 50 + 5*level, 9+level,"Orc Sorcerer");
    }
}
