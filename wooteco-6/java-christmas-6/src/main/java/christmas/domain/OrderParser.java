package christmas.domain;

import java.util.HashMap;
import java.util.Map;

public class OrderParser {
    public static Map<String, Integer> parseOrder(String order) {
        Map<String, Integer> orderedMenu = new HashMap<>();
        String[] orders = order.split(",");

        for (String orderMenu : orders) {
            String[] menuAndQuantity = orderMenu.split("-");
            String menu = menuAndQuantity[0].trim();
            int quantity = Integer.parseInt(menuAndQuantity[1].trim());

            orderedMenu.put(menu, orderedMenu.getOrDefault(menu, 0) + quantity);
        }

        return orderedMenu;
    }
}