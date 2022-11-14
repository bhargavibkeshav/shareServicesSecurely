import java.util.ArrayList;
public class Cart
{
    ArrayList<Element> ele = new ArrayList<Element>();
    public Cart(ArrayList<Element> ele) {
        this.ele=ele;
    }
    calcVisitor b = new calcVisitor();
    public double total;
    public double Total()
    {
        for(Element e : ele)
        {
            e.accept(b);
            total += b.TotalPrice();
        }

        return total;
    }
}
