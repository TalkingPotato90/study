package christmas.domain;

import java.time.LocalDate;

public class BadgeEvent implements Event {
    private static final LocalDate START_DATE = LocalDate.of(2023, 12, 1);
    private static final LocalDate END_DATE = LocalDate.of(2023, 12, 31);
    private static final int BADGE_1_THRESHOLD = 5000;
    private static final int BADGE_2_THRESHOLD = 10000;
    private static final int BADGE_3_THRESHOLD = 20000;

    @Override
    public boolean isApplicable(LocalDate date, int totalOrderAmount) {
        return date.isAfter(START_DATE) && date.isBefore(END_DATE);
    }

    @Override
    public int calculateDiscount(int totalOrderAmount) {
        return 0;
    }

    public String assignBadge(int totalBenefitAmount) {
        if (totalBenefitAmount >= BADGE_3_THRESHOLD) {
            return "산타";
        }
        if (totalBenefitAmount >= BADGE_2_THRESHOLD) {
            return "트리";
        }
        if (totalBenefitAmount >= BADGE_1_THRESHOLD) {
            return "별";
        }
        return "없음";
    }
}

