/**
 * Premade monster that constructs based on its level
 */
public class OrcGrunt extends Monster
{
    /**
     * Constructs using the super() with values based on level
     * @param level
     */
    public OrcGrunt(int level)
    {
        super(50 + 5*level, 5 + 5*((int) level/3), 7 + level,"Orc Grunt");
    }

}
