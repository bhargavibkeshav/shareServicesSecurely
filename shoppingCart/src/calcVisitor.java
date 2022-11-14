public class calcVisitor implements Visitor
{
    private double price;
    @Override
    public void visit(Book b)
    {
        price = b.getPrice() - (b.getPrice()/100);
    }
    public double TotalPrice()
    {
        return price;
    }
}
