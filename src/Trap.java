public class Trap extends Treasure
{
    private int trapDamage;

    public Trap(int inputDamage)
    {
        trapDamage = inputDamage;
    }

    public Object interact(Player inputPlayer)
    {
        inputPlayer.setHealth(inputPlayer.getHealth()-trapDamage);
        System.out.println("It's a trap! " + inputPlayer.getName() + " took " + trapDamage + " damage");
        return null;
    }
}
