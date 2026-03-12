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

        }
    }
}
