public class Player extends LivingBeing implements GameElement
{
    public Player(String inputName)
    {
        super(100, 40, 5, inputName);
    }



    public void fight(Object inputObj)
    {
        if (inputObj instanceof Monster)
        {
            Monster myMonster = (Monster) inputObj;
            if (myMonster.getSpeed() > this.getSpeed())
            {
                this.setHealth(this.getHealth()-myMonster.getAttack());
                System.out.println(myMonster.toString() + " attacked " + this.toString() + "for " + myMonster.getAttack() + " damage!");
                System.out.println(this.toString() + " now has " + this.getHealth() + " health.");
                if (this.getAlive())
                {
                    myMonster.setHealth(myMonster.getHealth()-this.getAttack());
                    System.out.println(this.toString() + " attacked " + myMonster.toString() + "for " + this.getAttack() + " damage!");
                    System.out.println(myMonster.toString() + " now has " + myMonster.getHealth() + " health.");
                }
            }
            else
            {
                myMonster.setHealth(myMonster.getHealth()-this.getAttack());
                System.out.println(this.toString() + " attacked " + myMonster.toString() + "for " + this.getAttack() + " damage!");
                System.out.println(myMonster.toString() + " now has " + myMonster.getHealth() + " health.");
                if (myMonster.getAlive())
                {
                    this.setHealth(this.getHealth()-myMonster.getAttack());
                    System.out.println(myMonster.toString() + " attacked " + this.toString() + "for " + myMonster.getAttack() + " damage!");
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
}
