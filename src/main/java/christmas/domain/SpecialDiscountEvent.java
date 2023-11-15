package christmas.domain;

import java.time.LocalDate;
import java.util.Set;

public class SpecialDiscountEvent implements Event {
    private static final LocalDate START_DATE = LocalDate.of(2023, 12, 1);
    private static final LocalDate END_DATE = LocalDate.of(2023, 12, 31);
    private static final int SPECIAL_DISCOUNT_AMOUNT = 1000;

    private static final Set<LocalDate> SPECIAL_DATES = Set.of(
            LocalDate.of(2023, 12, 1), LocalDate.of(2023, 12, 8), LocalDate.of(2023, 12, 15),
            LocalDate.of(2023, 12, 22), LocalDate.of(2023, 12, 24), LocalDate.of(2023, 12, 25)
    );

    @Override
    public boolean isApplicable(LocalDate date, int totalOrderAmount) {
        return date.isAfter(START_DATE) && date.isBefore(END_DATE);
    }

    @Override
    public int calculateDiscount(int totalOrderAmount) {
        LocalDate currentDate = LocalDate.now();

        if (totalOrderAmount >= 10000 && SPECIAL_DATES.contains(currentDate)) {
            return SPECIAL_DISCOUNT_AMOUNT;
        }

        return 0;
    }
}