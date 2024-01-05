package christmas.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EventManager {
    private List<Event> events;

    public EventManager() {
        this.events = new ArrayList<>();
        events.add(new ChristmasDiscountEvent());
        events.add(new DayOfWeekDiscountEvent());
        events.add(new BadgeEvent());
        events.add(new GiftEvent());
        events.add(new SpecialDiscountEvent());
    }

    public List<Event> getEvents() {
        return events;
    }

}
