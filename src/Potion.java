/**
 * Subclass of Treasure, that is able to heal a player by an amount stored within
 */
public class Potion extends Treasure
{
    /**
     * Field representing the amount of health given by the potion
     */
    int potionHealth;

    /**
     * Constructor setting up potionHealth
     * @param inputHealth The value assigned to potionHealth
     */
    public Potion(int inputHealth)
    {
        potionHealth = inputHealth;
    }

    /**
     * Heals the input player by the health amount
     * @param inputPlayer The player to be interacted with
     * @return Returns null, as this implementation of interact() does not need a return value
     */
    public Object interact(Player inputPlayer)
    {
        inputPlayer.setHealth(inputPlayer.getHealth() + potionHealth);
        System.out.println(inputPlayer.getName() + " healed for " + potionHealth);
        return null;
    }
}
