package christmas.domain;

import java.util.HashMap;
import java.util.Map;

public class MenuPrice {
    private static final Map<String, Integer> MENU_PRICES = new HashMap<>();

    static {
        // 메뉴 가격 설정
        MENU_PRICES.put("양송이수프", 6000);
        MENU_PRICES.put("타파스", 5500);
        MENU_PRICES.put("시저샐러드", 8000);
        MENU_PRICES.put("티본스테이크", 55000);
        MENU_PRICES.put("바비큐립", 54000);
        MENU_PRICES.put("해산물파스타", 35000);
        MENU_PRICES.put("크리스마스파스타", 25000);
        MENU_PRICES.put("초코케이크", 15000);
        MENU_PRICES.put("아이스크림", 5000);
        MENU_PRICES.put("제로콜라", 3000);
        MENU_PRICES.put("레드와인", 60000);
        MENU_PRICES.put("샴페인", 25000);
    }

    public static int getPrice(String menu) {
        return MENU_PRICES.getOrDefault(menu, 0);
    }
}
