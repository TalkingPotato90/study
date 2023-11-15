package christmas.View;

import java.util.Map;

public class OutputView {
    public void welcome(){
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public void showEventPreview(int visitDate) {
        System.out.println("12월 " + visitDate + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
    }

    public void showOrderedMenu(Map<String, Integer> orderedMenu) {
        System.out.println("<주문 메뉴>");
        for (Map.Entry<String, Integer> entry : orderedMenu.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue() + "개");
        }
        System.out.println();
    }

    public void showTotalOrderAmount(int totalOrderAmount) {
        System.out.println("<할인 전 총주문 금액>");
        System.out.printf("%,d원%n", totalOrderAmount);
        System.out.println();
    }

    public void printGiftMenu(String giftMenu) {
        System.out.println("<증정 메뉴>");
        System.out.println(giftMenu);
    }

    public void showTotalBenefitsAmount(int totalBenefitAmount) {
        System.out.println("<총혜택 금액>");
        System.out.printf("%,d원%n", totalBenefitAmount);
        System.out.println();
    }

    public void showFinalPaymentAmount(int finalPaymentAmount) {
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.printf("%,d원%n", finalPaymentAmount);
        System.out.println();
    }

}
