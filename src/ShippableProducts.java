public class ShippableProducts extends Products implements Shippable {
    protected double weight;
    public ShippableProducts(String name, double price, int quantity, double weight) {
        super(name, price, quantity);
        this.weight = weight;
    }

    public String getName () {
        return this.name;
    }
    public double getWeight(){
        return this.weight;
    }
}
