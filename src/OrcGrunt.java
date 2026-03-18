public class OrcGrunt extends Monster
{
    public OrcGrunt(int level)
    {
        super(50 + 5*level, 5 + 5*((int) level/3), 7 + level,"Orc Grunt");
    }

}
