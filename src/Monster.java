import java.util.Random;

public class Monster implements GameElement, PlayerInteractable
{
    int health;
    int attack;
    String typeName;
    Random randomizer;

    public Monster()
    {

    }

    public Monster(int inputHealth, int inputAttack, String inputTypeName)
    {
        health = inputHealth;
        attack = inputAttack;
        typeName = inputTypeName;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String toString()
    {
        return typeName;
    }

    public Object interact(Player inputPlayer)
    {
        return null;
    }
}
