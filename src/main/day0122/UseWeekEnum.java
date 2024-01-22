package day0122;

public class UseWeekEnum {
    public static void main(String[] args) {

        // 생성자를 가진 enum은 요소에 할당된 method를 통해 이름과 값을 얻을 수 있다
        Week week = Week.MON;
        System.out.println(week.getName());
        System.out.println(week.getValue());
        System.out.println(week.ordinal());

        System.out.println("----------------------------");
        for (Week w : week.values()) {
            System.out.println(w.getName() + " / " + w.getValue() + " / " + w.ordinal());
        }

        // switch~case 사용
        Week key = Week.MON;
        switch (key) {
            case MON:
                System.out.println(key.getName());
                break;
            case TUE:
                System.out.println(key.getName());
                break;
            case WED:
                System.out.println(key.getName());
                break;
            default:
                System.out.println("해당사항 없음");
        }

        // if 비교 == 으로 비교
        key = Week.MON;
        if (key == Week.MON) {
            System.out.println("월요병 오지는 월요일!!!");
        } else if (key == Week.TUE) {
            System.out.println("화요병 화요일!!!");
        } else {
            System.out.println("괜찮은 날!!!");
        }
    }
}
