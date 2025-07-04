import java.util.*;

public class Cart {

    private final Map<Products, Integer> items = new LinkedHashMap<>();
    public void add(Products product, int qty) {
        if (product instanceof Expirable) {
            Expirable exp = (Expirable) product;
            if (exp.isExpired()) {
                System.out.println(product.name + " is expired and cannot be added");
            }
        }
        int existing = (items.containsKey(product) ? items.get(product) : 0);
        if (existing + qty > product.quantity) {
            System.out.println(
                    "Not enough stock for " + product.name + ". Requested: " + (existing + qty) + ", available: " + product.quantity
            );
        }
        items.put(product, existing + qty);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void checkout(Customer customer) {
        double totalFees = 0;
        if (isEmpty()) {
            System.out.println("No thing in the shopping cart.");
        }

        Map<Shippable , Integer> Shippables = new HashMap<>() ;
        Map<Products , Integer> all = new HashMap<>() ;
        for (Map.Entry<Products, Integer> entry : items.entrySet()) {
            Products p = entry.getKey();
            int qty = entry.getValue();

            if (p instanceof Expirable && ((Expirable) p).isExpired()) {
                System.out.println(p.name + " is expired.");
                continue;
            }
            if(p instanceof Shippable) {
                int existing = Shippables.containsKey(p) ? Shippables.get(p) : 0;
                Shippables.put((Shippable) p, existing + qty);
            }
            int existing = Shippables.containsKey(p) ? Shippables.get(p) : 0;
            all.put(p, existing + qty);
            p.buy(qty);
        }
        SimpleShippingService service = new SimpleShippingService();
        service.ship(Shippables);
        printShipping(all);
    }

    public void printShipping (Map<Products , Integer> all) {
        double total = 0 ;
        double totalFees = 0;
        System.out.println("************ Checkout receipet *********");
        for (Map.Entry<Products, Integer> entry : all.entrySet()) {
            Products p = entry.getKey();
            int qty = entry.getValue();
            System.out.println(entry.getValue()+"x " + entry.getKey().getName() + "       " + p.price * qty + " LE" ) ;
            total += p.price * qty ;
        }
        totalFees = total / 10.0 ;
        System.out.println("---------------------------") ;
        System.out.println("Subtotal  " + total) ;
        System.out.println("Shipping  " + totalFees) ;
        System.out.println("Total   " + total + totalFees) ;
    }

}
