package christmas.domain;

import java.time.LocalDate;

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
        int daysSinceStart = (int) START_DATE.datesUntil(currentDate).count();
        int discount = INITIAL_DISCOUNT + daysSinceStart * DAILY_INCREMENT;

        if (totalOrderAmount >= 10000) {
            return Math.min(discount, totalOrderAmount);
        }

        return 0;
    }
}
