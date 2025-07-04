public class Customer {
    public double balance ;

    Customer (int b) {
        balance = b;
    }
    public void charge(double amount) {
        if (amount > balance) {
            System.out.println("Not enough money");
        }
        balance -= amount;
    }
}
