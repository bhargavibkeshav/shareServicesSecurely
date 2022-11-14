public class Book implements Element
{
    public String bookName;
    private double price;
    private int pages;
    public Book(double price, int pages)
    {
        this.price=price;
        this.pages=pages;
    }
    @Override
    public void accept(Visitor visit)
    {
        visit.visit(this);
    }
    public void setPrice(double price)
    {
        this.price = price;
    }
    public void setPages(int pages)
    {
        this.price = pages;
    }
    public double getPrice()
    {
        return this.price;
    }
    public int getPages()
    {
        return this.pages;
    }
}
