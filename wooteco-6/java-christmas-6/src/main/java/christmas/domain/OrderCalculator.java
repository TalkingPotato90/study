package christmas.domain;

import java.util.Map;

public class OrderCalculator {
    public static int calculateTotalOrderAmount(String order) {
        Map<String, Integer> orderedMenu = OrderParser.parseOrder(order);
        return orderedMenu.entrySet().stream()
                .mapToInt(entry -> MenuPrice.getPrice(entry.getKey()) * entry.getValue())
                .sum();
    }
}
