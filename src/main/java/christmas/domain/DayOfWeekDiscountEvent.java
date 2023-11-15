package christmas.domain;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Set;

public class DayOfWeekDiscountEvent implements Event {
    private static final LocalDate START_DATE = LocalDate.of(2023, 12, 1);
    private static final LocalDate END_DATE = LocalDate.of(2023, 12, 31);
    private static final int WEEKDAY_DISCOUNT = 2023;
    private static final int WEEKEND_DISCOUNT = 2023;

    private static final Set<DayOfWeek> WEEKDAYS = Set.of(
            DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY
    );

    @Override
    public boolean isApplicable(LocalDate date, int totalOrderAmount) {
        return date.isAfter(START_DATE) && date.isBefore(END_DATE);
    }

    @Override
    public int calculateDiscount(LocalDate visitDate, int totalOrderAmount) {
        LocalDate currentDate = LocalDate.now();
        DayOfWeek dayOfWeek = currentDate.getDayOfWeek();

        if (totalOrderAmount >= 10000 && WEEKDAYS.contains(dayOfWeek)) {
            return WEEKDAY_DISCOUNT;
        }

        if (totalOrderAmount >= 10000 && !WEEKDAYS.contains(dayOfWeek)) {
            return WEEKEND_DISCOUNT;
        }

        return 0;
    }
}
