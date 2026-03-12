public class LivingBeing implements GameElement
{
    private int health;
    private int attack;
    private int speed;
    private String name;

    public LivingBeing(int inputHealth, int inputAttack, int inputSpeed, String inputName)
    {
        health = inputHealth;
        attack = inputAttack;
        speed = inputSpeed;
        name = inputName;
    }

    public int getHealth()
    {
        return health;
    }

    public int getAttack()
    {
        return attack;
    }

    public int getSpeed()
    {
        return speed;
    }

    public String getName()
    {
        return name;
    }

    public void setHealth(int inputHealth)
    {
        health = inputHealth;
    }

    public void setAttack(int inputAttack)
    {
        attack = inputAttack;
    }

    public void setSpeed(int inputSpeed)
    {
        speed = inputSpeed;
    }

    public void setName(String inputName)
    {
        name = inputName;
    }

    public boolean getAlive()
    {
        return health > 0;
    }

    public void printStats()
    {
        System.out.println("Health: " + this.getHealth());
        System.out.println("Attack: " + this.getAttack());
        System.out.println("Speed: " + this.getSpeed());
    }

    public String toString()
    {
        return name;
    }
}
