package christmas.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class GiftEventTest {
    @Test
    public void 정상_증정() {
        GiftEvent giftEvent = new GiftEvent();
        LocalDate applicableDate = LocalDate.of(2023, 12, 15);
        int totalOrderAmount = 130000;

        boolean isApplicable = giftEvent.isApplicable(applicableDate, totalOrderAmount);

        assertTrue(isApplicable);
    }


    @Test
    public void 주문_금액_미달() {
        GiftEvent giftEvent = new GiftEvent();
        LocalDate applicableDate = LocalDate.of(2023, 12, 15);
        int lowOrderAmount = 100000;

        boolean isApplicable = giftEvent.isApplicable(applicableDate, lowOrderAmount);

        assertFalse(isApplicable);
    }

    @Test
    public void 할인금액은_0원() {
        GiftEvent giftEvent = new GiftEvent();
        LocalDate visitDate = LocalDate.of(2023, 12, 20);
        int totalOrderAmount = 150000;

        int discountAmount = giftEvent.calculateDiscount(visitDate, totalOrderAmount);

        assertEquals(0, discountAmount);
    }
}