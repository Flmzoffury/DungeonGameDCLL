public class Potion extends Treasure
{
    int potionHealth;

    public Potion(int inputHealth)
    {
        potionHealth = inputHealth;
    }

    public Object interact(Player inputPlayer)
    {
        inputPlayer.setHealth(inputPlayer.getHealth() + potionHealth);
        System.out.println(inputPlayer.getName() + " healed for " + potionHealth);
        return null;
    }
}
