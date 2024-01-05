package christmas.domain;

import java.time.LocalDate;

public interface Event {
    boolean isApplicable(LocalDate date, int totalOrderAmount);

    int calculateDiscount(LocalDate visitDate, int totalOrderAmount);
}

