package christmas.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BadgeEventTest {

    @Test
    public void 금액별_배지_확인() {
        BadgeEvent badgeEvent = new BadgeEvent();
        int totalBenefitAmount1 = 3000;
        int totalBenefitAmount2 = 8000;
        int totalBenefitAmount3 = 15000;
        int totalBenefitAmount4 = 25000;

        String badge1 = badgeEvent.assignBadge(totalBenefitAmount1);
        String badge2 = badgeEvent.assignBadge(totalBenefitAmount2);
        String badge3 = badgeEvent.assignBadge(totalBenefitAmount3);
        String badge4 = badgeEvent.assignBadge(totalBenefitAmount4);

        assertEquals("없음", badge1);
        assertEquals("별", badge2);
        assertEquals("트리", badge3);
        assertEquals("산타", badge4);
    }

}