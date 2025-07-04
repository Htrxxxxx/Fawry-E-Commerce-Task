import java.util.List;
import java.util.Map;

public class SimpleShippingService implements ShippingService {
    double totalWeight = 0.0 ;
    public void ship(Map<Shippable , Integer> items){
        System.out.println(" ***** Shipment Notice ***** ");
        for (Map.Entry<Shippable, Integer> entry : items.entrySet()) {
            double w = entry.getValue() * entry.getKey().getWeight() ;
            totalWeight += w ;
            System.out.println(entry.getValue()+"x " + entry.getKey().getName() + " " + w);
        }
        System.out.println("Total Package Weight : " + totalWeight );
        System.out.println();
    }
}
