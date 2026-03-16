import java.util.ArrayList;

public class Player extends LivingBeing implements GameElement
{
    private ArrayList<Equipment> inventory;
    private int xp;

    public Player(String inputName)
    {
        super(100, 40, 5, inputName);
        inventory = new ArrayList<Equipment>();
        xp = 0;
    }

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

    public void printInv()
    {
        System.out.println("Inventory:");
        for (int i = 0; i < inventory.size(); i++)
        {
            System.out.print(inventory.get(i).getName() + " ");
        }
        System.out.println("");
    }

    public void equip(Equipment inputEquipment)
    {
        this.setAttack(this.getAttack()+inputEquipment.getAttackBoost());
        this.setSpeed(this.getSpeed()+inputEquipment.getSpeedBoost());
        inventory.add(inputEquipment);
    }
}
