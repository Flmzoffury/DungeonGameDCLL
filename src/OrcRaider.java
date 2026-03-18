public class OrcRaider extends Monster
{
    public OrcRaider(int level)
    {
        super(80 + 5*level, 10+5*((int) level/2), 8 + level,"Orc Raider");
    }
}
