/**
 * Premade monster that constructs based on its level
 */
public class OrcBrute extends Monster
{
    /**
     * Constructs using the super() with values based on level
     * @param level
     */
    public OrcBrute(int level)
    {
        super(120 + 10*level, 40 + 10*level, 1,"Orc Brute");
    }
}
