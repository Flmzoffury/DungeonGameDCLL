import java.util.Random;

/**
 * Subclass of Living being that specifies the being as an enemy monster
 */
public class Monster extends LivingBeing implements GameElement
{
    /**
     * Utilizes the superclasses constructor
     * @param inputHealth Used as the inputHealth in super()
     * @param inputAttack Used as the inputAttack in super()
     * @param inputSpeed Used as the inputSpeed in super()
     * @param inputTypeName Used as the inputName in super()
     */
    public Monster(int inputHealth, int inputAttack, int inputSpeed, String inputTypeName)
    {
        super(inputHealth, inputAttack, inputSpeed, inputTypeName);
    }
}
