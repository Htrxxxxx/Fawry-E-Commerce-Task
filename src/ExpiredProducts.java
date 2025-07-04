import java.time.LocalDateTime;

public class ExpiredProducts extends Products {
    protected LocalDateTime expiredDate ;
    public ExpiredProducts(String name, double price, int quantity) {
        super(name, price, quantity);
        this.expiredDate = LocalDateTime.now().plusHours(24);
    }
}
