import java.time.LocalDateTime;
public class ShippableAndExpired extends Products implements Shippable,Expirable {
    protected LocalDateTime expirationDateTime;
    protected double weight;
    public ShippableAndExpired(String name, double price, int quantity, double weight) {
        super(name, price, quantity);
        this.weight = weight;
        this.expirationDateTime = LocalDateTime.now().plusHours(24);
    }
    public String getName(){
        return this.name;
    }
    public double getWeight(){
        return this.weight;
    }
    public boolean isExpired(){
        return this.expirationDateTime.isAfter(LocalDateTime.now());
    }
}
