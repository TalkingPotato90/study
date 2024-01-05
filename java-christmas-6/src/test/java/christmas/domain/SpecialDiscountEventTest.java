package christmas.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class SpecialDiscountEventTest {
    @Test
    public void 정상_할인() {
        SpecialDiscountEvent specialEvent = new SpecialDiscountEvent();
        LocalDate applicableDate = LocalDate.of(2023, 12, 15);
        int totalOrderAmount = 130000;

        boolean isApplicable = specialEvent.isApplicable(applicableDate, totalOrderAmount);

        assertTrue(isApplicable);
    }

    @Test
    public void 기준금액_미달() {
        SpecialDiscountEvent specialDiscountEvent = new SpecialDiscountEvent();
        LocalDate visitDate = LocalDate.of(2023, 12, 2);
        int totalOrderAmount = 5000;

        int discount = specialDiscountEvent.calculateDiscount(visitDate, totalOrderAmount);

        assertEquals(0, discount);
    }

    @Test
    public void 별표날짜_할인() {
        SpecialDiscountEvent specialEvent = new SpecialDiscountEvent();
        LocalDate specialDate = LocalDate.of(2023, 12, 24);
        int totalOrderAmount = 15000;

        int discountAmount = specialEvent.calculateDiscount(specialDate, totalOrderAmount);

        assertEquals(1000, discountAmount);
    }

    @Test
    public void 별_없는_날_할인_안함() {
        SpecialDiscountEvent specialEvent = new SpecialDiscountEvent();
        LocalDate nonSpecialDate = LocalDate.of(2023, 12, 10);
        int totalOrderAmount = 15000;

        int discountAmount = specialEvent.calculateDiscount(nonSpecialDate, totalOrderAmount);

        assertEquals(0, discountAmount);
    }
}