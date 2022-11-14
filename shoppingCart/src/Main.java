import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        ArrayList<Element> e = new ArrayList<Element>();
        e.add(new Book(20,200));
        e.add(new Book(10, 1000));

        Cart c = new Cart(e);
        System.out.println(c.Total());
    }
}