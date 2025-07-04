import java.util.List;
import java.util.Map;

public interface ShippingService {
    void ship(Map<Shippable , Integer> items);
}