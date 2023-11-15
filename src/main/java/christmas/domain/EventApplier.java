package christmas.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EventApplier {
    public static List<String> applyEvents(List<Event> events, LocalDate visitDate, int totalOrderAmount) {
        List<String> discountDetails = new ArrayList<>();

        for (Event event : events) {
            if (event.isApplicable(visitDate, totalOrderAmount)) {
                int discountAmount = event.calculateDiscount(totalOrderAmount);
                if (discountAmount > 0) {
                    discountDetails.add(event.getClass().getSimpleName() + ": -" + discountAmount + "원");
                    totalOrderAmount -= discountAmount;
                }
            }
        }

        return discountDetails;
    }

    public static int calculateTotalBenefitAmount(List<String> discountDetails) {
        return discountDetails.stream()
                .map(detail -> detail.split(": -")[1].replace("원", ""))
                .mapToInt(Integer::parseInt)
                .sum();
    }


}
