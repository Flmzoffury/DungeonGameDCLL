/**
 * Trap class that deals damage to the player ono player interaction
 */
public class Trap extends Treasure
{
    /**
     * The amount of damage a trap does to the player
     */
    private int trapDamage;

    /**
     * Constructor for Trap
     * @param inputDamage sets the trapDamage
     */
    public Trap(int inputDamage)
    {
        trapDamage = inputDamage;
    }

    /**
     * Player interaction, damages the player by trapDamage
     * @param inputPlayer The player interacting with the trap
     * @return null
     */
    public Object interact(Player inputPlayer)
    {
        inputPlayer.setHealth(inputPlayer.getHealth()-trapDamage);
        System.out.println("It's a trap! " + inputPlayer.getName() + " took " + trapDamage + " damage");
        return null;
    }
}
