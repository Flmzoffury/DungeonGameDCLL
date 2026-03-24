import java.util.Scanner;
/**
 * Type of Treasure that is equipped by the player
 */
public class Equipment extends Treasure
{
    /**
     * The attack boost provided by the equipment
     */
    int attackBoost;
    /**
     * The speed boost provided by the equipment
     */
    int speedBoost;
    /**
     * The name of the equipment
     */
    String name;
    /**
     * Scanner to read player input
     */
    Scanner inputReader;

    /**
     * Constructor for equipment
     * @param inputAttack Sets attackBoost
     * @param inputSpeed Sets speedBoost
     * @param inputName Sets the name of the equipment
     */
    public Equipment(int inputAttack, int inputSpeed, String inputName)
    {
        attackBoost = inputAttack;
        speedBoost = inputSpeed;
        name = inputName;
        inputReader = new Scanner(System.in);
    }

    /**
     * Interacts with the player, prompting thte user to equip it or not
     * @param inputPlayer the player that is interacting with the Treasure
     * @return
     */
    public Object interact(Player inputPlayer)
    {
        System.out.println("You have found a " + name);
        System.out.println("It has:\nSpeed: " + speedBoost + "\nAttack: " + attackBoost);
        System.out.println("Equip? Y/N");
        String input = inputReader.nextLine().toUpperCase();

        if (input.equals("Y"))
        {
            inputPlayer.equip(this);
        }

        return null;
    }

    /**
     * Getter for attackBoost
     * @return attackBoost
     */
    public int getAttackBoost()
    {
        return attackBoost;
    }

    /**
     * Getter for speedBoost
     * @return speedBoost
     */
    public int getSpeedBoost()
    {
        return speedBoost;
    }

    /**
     * Getter for name
     * @return name
     */
    public String getName()
    {
        return name;
    }
}