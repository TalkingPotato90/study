package christmas.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class OrderValidator {
    private static final Set<String> APPETIZER_MENU = new HashSet<>(Arrays.asList("양송이수프","타파스","시저샐러드"));
    private static final Set<String> MAIN_MENU = new HashSet<>(Arrays.asList("티본스테이크", "바비큐립", "해산물파스타", "크리스마스파스타"));
    private static final Set<String> DESSERT_MENU = new HashSet<>(Arrays.asList("초코케이크", "아이스크림"));
    private static final Set<String> BEVERAGE_MENU = new HashSet<>(Arrays.asList("제로콜라", "레드와인", "샴페인"));
    public static boolean isValidOrder(String order){
        try {
            validateOnMenu(order);
            validateQuantity(order);
            validateFormat(order);
            validateDuplicateMenu(order);
            validateTotalQuantity(order);
            validateBeverageOnly(order);

            return true;
        } catch (IllegalArgumentException e){
            return false;
        }
    }

    private static void validateOnMenu(String order){
        String[] orders = order.split(",");

        for (String orderMenu : orders) {
            String[] menuAndQuantity = orderMenu.split("-");
            String menu = menuAndQuantity[0].trim();

            if (!APPETIZER_MENU.contains(menu) && !MAIN_MENU.contains(menu) &&
                    !DESSERT_MENU.contains(menu) && !BEVERAGE_MENU.contains(menu)) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
        }
    }

    private static void validateQuantity(String order){
        String[] orders = order.split(",");
        for (String orderMenu : orders) {
            int quantity = Integer.parseInt(orderMenu.split("-")[1].trim());

            if (quantity < 1 || quantity > 20) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
        }
    }

    private static void validateFormat(String order){
        if (!order.matches("^[^,]+-\\d+(,[^,]+-\\d+)*$")) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private static void validateDuplicateMenu(String order){
        String[] orders = order.split(",");
        Set<String> menuSet = new HashSet<>();

        for (String orderMenu : orders) {
            String[] menuAndQuantity = orderMenu.split("-");
            String menu = menuAndQuantity[0].trim();

            if (!menuSet.add(menu)) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
        }
    }

    private static void validateTotalQuantity(String order){
        String[] orders = order.split(",");
        int totalQuantity = 0;

        for (String orderMenu : orders) {
            int quantity = Integer.parseInt(orderMenu.split("-")[1].trim());
            totalQuantity += quantity;
        }

        if (totalQuantity > 20) {
            System.out.println("[ERROR] 주문 메뉴의 총 수량은 20개를 초과할 수 없습니다.");
            throw new IllegalArgumentException("[ERROR] 주문 메뉴의 총 수량은 20개를 초과할 수 없습니다.");
        }
    }

    private static void validateBeverageOnly(String order){

    }
}
