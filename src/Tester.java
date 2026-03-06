

public class Tester
{
    public static void main(String[] args)
    {
        SamDCLL<String> sam = new SamDCLL<String>();
        sam.add("Hello");
        sam.add("Yello");
        sam.add("Nope");
        sam.print();
    }


}
