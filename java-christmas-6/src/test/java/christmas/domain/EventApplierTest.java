package christmas.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EventApplierTest {

    @Test
    void 할인이벤트_적용_확인() {
        Event christmasEvent = new ChristmasDiscountEvent();
        Event dayOfWeekEvent = new DayOfWeekDiscountEvent();
        List<Event> events = List.of(christmasEvent, dayOfWeekEvent);
        LocalDate visitDate = LocalDate.of(2023, 12, 3);
        int totalOrderAmount = 15000;

        List<String> discountDetails = EventApplier.applyEvents(events, visitDate, totalOrderAmount);

        assertEquals(2, discountDetails.size());
        assertEquals("ChristmasDiscountEvent: -1200원", discountDetails.get(0));
        assertEquals("DayOfWeekDiscountEvent: -2023원", discountDetails.get(1));
    }

    @Test
    void 혜택금액_확인() {
        List<String> discountDetails = List.of("Event1: -1000원", "Event2: -500원", "Event3: -800원");

        int totalBenefitAmount = EventApplier.calculateTotalBenefitAmount(discountDetails);

        assertEquals(2300, totalBenefitAmount);
    }

    @Test
    void 증정이벤트_확인() {
        Event giftEvent = new GiftEvent();
        List<Event> events = List.of(giftEvent);
        int totalOrderAmount = 130000;

        String giftMenu = EventApplier.calculateGiftMenu(events, totalOrderAmount);

        assertEquals("샴페인 1개", giftMenu);
    }

    @Test
    void 최종결제금액_확인() {
        int totalOrderAmount = 25000;
        int totalBenefitAmount = 8000;

        int finalPaymentAmount = EventApplier.calculateFinalPaymentAmount(totalOrderAmount, totalBenefitAmount);

        assertEquals(17000, finalPaymentAmount);
    }
}