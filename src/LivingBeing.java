public class LivingBeing implements GameElement
{

    /**
     * The LivingBeing's current health
     */
    private int health;
    /**
     * The LivingBeing's current attack
     */
    private int attack;
    /**
     * The LivingBeing's current speed
     */
    private int speed;
    /**
     * The LivingBeing's name
     */
    private String name;

    /**
     * Constructor creates a viable LivingBeing
     * @param inputHealth The starting health
     * @param inputAttack The being's attack
     * @param inputSpeed The being's speed
     * @param inputName The being's name
     */
    public LivingBeing(int inputHealth, int inputAttack, int inputSpeed, String inputName)
    {
        health = inputHealth;
        attack = inputAttack;
        speed = inputSpeed;
        name = inputName;
    }

    /**
     * Gets health
     * @return health
     */
    public int getHealth()
    {
        return health;
    }

    /**
     * Gets attack
     * @return attack
     */
    public int getAttack()
    {
        return attack;
    }

    /**
     * Gets speed
     * @return speed
     */
    public int getSpeed()
    {
        return speed;
    }

    /**
     * Gets name
     * @return name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Setter for health
     * @param inputHealth is assigned to health
     */
    public void setHealth(int inputHealth)
    {
        health = inputHealth;
    }

    /**
     * Setter for attack
     * @param inputAttack is assigned to attack
     */
    public void setAttack(int inputAttack)
    {
        attack = inputAttack;
    }

    /**
     * Setter for speed
     * @param inputSpeed is assigned to speed
     */
    public void setSpeed(int inputSpeed)
    {
        speed = inputSpeed;
    }

    /**
     * Setter for name
     * @param inputName is assigned to name
     */
    public void setName(String inputName)
    {
        name = inputName;
    }

    /**
     * Returns whether or not the being is alive
     * @return The boolean value of health > 0
     */
    public boolean getAlive()
    {
        return health > 0;
    }

    /**
     * Prints all of the stats of the being
     */
    public void printStats()
    {
        System.out.println("Health: " + this.getHealth());
        System.out.println("Attack: " + this.getAttack());
        System.out.println("Speed: " + this.getSpeed());
    }

    /**
     * Returns the name of the being for display in the dungeon
     * @return name
     */
    public String toString()
    {
        return name;
    }
}
