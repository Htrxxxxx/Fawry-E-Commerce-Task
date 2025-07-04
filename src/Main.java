public class Main {
    public static void main(String[] args) {
        Customer c = new Customer(100);
        Cart cart = new Cart();

        UnShippedUnExpired TV = new UnShippedUnExpired("tv" , 100 , 100) ;
        ShippableProducts cheese = new ShippableProducts("chesse" , 100 , 100 , 50) ;

        cart.add(TV , 10);
        cart.add(cheese , 100);
        // cart.add(cheese, 0);
        cart.checkout(c);
    }
}