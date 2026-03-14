import java.util.Scanner;

public class Equipment extends Treasure
{
    int attackBoost;
    int speedBoost;
    String name;
    Scanner inputReader;

    public Equipment(int inputAttack, int inputSpeed, String inputName)
    {
        attackBoost = inputAttack;
        speedBoost = inputSpeed;
        name = inputName;
        inputReader = new Scanner(System.in);
    }

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

    public int getAttackBoost()
    {
        return attackBoost;
    }

    public int getSpeedBoost()
    {
        return speedBoost;
    }

    public String getName()
    {
        return name;
    }
}