package christmas.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ChristmasDiscountEventTest {
    @Test
    public void 방문날짜에_따른_할인() {
        ChristmasDiscountEvent christmasEvent = new ChristmasDiscountEvent();
        LocalDate visitDate = LocalDate.of(2023, 12, 3);
        int totalOrderAmount = 15000;

        int discount = christmasEvent.calculateDiscount(visitDate, totalOrderAmount);

        assertEquals(1200, discount);
    }

    @Test
    public void 주문금액미달_할인없음() {
        ChristmasDiscountEvent christmasEvent = new ChristmasDiscountEvent();
        LocalDate visitDate = LocalDate.of(2023, 12, 3);
        int totalOrderAmount = 8000;

        int discount = christmasEvent.calculateDiscount(visitDate, totalOrderAmount);

        assertEquals(0, discount);
    }
}