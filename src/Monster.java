import java.util.Random;

public class Monster extends LivingBeing implements GameElement
{
    public Monster(int inputHealth, int inputAttack, int inputSpeed, String inputTypeName)
    {
        super(inputHealth, inputAttack, inputSpeed, inputTypeName);
    }
}
