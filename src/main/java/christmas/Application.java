package christmas;

import christmas.View.InputView;
import christmas.View.OutputView;
import christmas.domain.*;

import java.time.LocalDate;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        outputView.welcome();

        int visitDate = inputView.inputDate();

        String order = inputView.inputOrder();

        outputView.showOrderedMenu(OrderParser.parseOrder(order));

        int totalOrderAmount = OrderCalculator.calculateTotalOrderAmount(order);
        outputView.showTotalOrderAmount(totalOrderAmount);

        outputView.showEventPreview(visitDate);

        List<Event> events = List.of(
                new ChristmasDiscountEvent(),
                new DayOfWeekDiscountEvent(),
                new BadgeEvent(),
                new GiftEvent(),
                new SpecialDiscountEvent()
        );

        List<String> discountDetails = EventApplier.applyEvents(events, LocalDate.of(2023, 12, visitDate), totalOrderAmount);

        outputView.showDiscounts(discountDetails);

        int totalBenefitAmount = EventApplier.calculateTotalBenefitAmount(discountDetails);
        outputView.showTotalBenefitsAmount(totalBenefitAmount);

        String badge = new BadgeEvent().assignBadge(totalBenefitAmount);
        outputView.showEventBadge(badge);

        String giftMenu = EventApplier.calculateGiftMenu(events, totalOrderAmount);
        outputView.printGiftMenu(giftMenu);

        int finalPaymentAmount = EventApplier.calculateFinalPaymentAmount(totalOrderAmount, totalBenefitAmount);
        outputView.showFinalPaymentAmount(finalPaymentAmount);
    }
}

