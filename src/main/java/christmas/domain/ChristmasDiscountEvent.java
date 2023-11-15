package christmas.domain;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ChristmasDiscountEvent implements Event {
    private static final LocalDate START_DATE = LocalDate.of(2023, 12, 1);
    private static final LocalDate END_DATE = LocalDate.of(2023, 12, 25);
    private static final int INITIAL_DISCOUNT = 1000;
    private static final int DAILY_INCREMENT = 100;

    @Override
    public boolean isApplicable(LocalDate date, int totalOrderAmount) {
        return date.isAfter(START_DATE) && date.isBefore(END_DATE);
    }

    @Override
    public int calculateDiscount(int totalOrderAmount) {
        LocalDate currentDate = LocalDate.now();
        long daysSinceStart = ChronoUnit.DAYS.between(START_DATE, currentDate);
        int discount = INITIAL_DISCOUNT + (int) (daysSinceStart * DAILY_INCREMENT);

        if (totalOrderAmount >= 10000) {
            return Math.min(discount, totalOrderAmount);
        }

        return 0;
    }
}
