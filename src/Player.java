import java.util.ArrayList;

/**
 * Subclass of LivingBeing that represents the player characted
 */
public class Player extends LivingBeing implements GameElement
{
    /**
     * The equipment inventory of the player
     */
    private ArrayList<Equipment> inventory;
    //private int xp;

    /**
     * Constructs the player using sets stats and a player input name
     * @param inputName The player's name
     */
    public Player(String inputName)
    {
        super(100, 40, 5, inputName);
        inventory = new ArrayList<Equipment>();
        //xp = 0;
    }

    /**
     * If the input is a monster, it fights the monster
     * @param inputObj The object to be fought
     */
    public void fight(Object inputObj)
    {
        if (inputObj instanceof Monster)
        {
            Monster myMonster = (Monster) inputObj;
            if (myMonster.getSpeed() > this.getSpeed())
            {
                this.setHealth(this.getHealth()-myMonster.getAttack());
                System.out.println(myMonster.toString() + " attacked " + this.toString() + " for " + myMonster.getAttack() + " damage!");
                System.out.println(this.toString() + " now has " + this.getHealth() + " health.");
                if (this.getAlive())
                {
                    myMonster.setHealth(myMonster.getHealth()-this.getAttack());
                    System.out.println(this.toString() + " attacked " + myMonster.toString() + " for " + this.getAttack() + " damage!");
                    System.out.println(myMonster.toString() + " now has " + myMonster.getHealth() + " health.");
                }
            }
            else
            {
                myMonster.setHealth(myMonster.getHealth()-this.getAttack());
                System.out.println(this.toString() + " attacked " + myMonster.toString() + " for " + this.getAttack() + " damage!");
                System.out.println(myMonster.toString() + " now has " + myMonster.getHealth() + " health.");
                if (myMonster.getAlive())
                {
                    this.setHealth(this.getHealth()-myMonster.getAttack());
                    System.out.println(myMonster.toString() + " attacked " + this.toString() + " for " + myMonster.getAttack() + " damage!");
                    System.out.println(this.toString() + " now has " + this.getHealth() + " health.");
                }
            }

            if (!this.getAlive())
            {
                System.out.println(this.toString() + " has been defeated.");
            }
            else if (!myMonster.getAlive())
            {
                System.out.println(myMonster.toString() + " has been defeated.");
            }
        }
    }

    /**
     * Prints out the inventory of the player
     */
    public void printInv()
    {
        System.out.println("Inventory:");
        for (int i = 0; i < inventory.size(); i++)
        {
            System.out.print(inventory.get(i).getName() + " ");
        }
        System.out.println("");
    }

    /**
     * Equips a piece of equipment to the player
     * @param inputEquipment The equipment to be equipped
     */
    public void equip(Equipment inputEquipment)
    {
        this.setAttack(this.getAttack()+inputEquipment.getAttackBoost());
        this.setSpeed(this.getSpeed()+inputEquipment.getSpeedBoost());
        inventory.add(inputEquipment);
    }
}
