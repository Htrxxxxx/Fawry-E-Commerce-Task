import java.util.Queue;

public abstract class Products {
    protected String name ;
    protected double price;
    protected int quantity;

    public Products(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }
    public void buy (int x) {
        if (x > quantity) System.out.println("Not enough");
        quantity -= x;
    }
}
