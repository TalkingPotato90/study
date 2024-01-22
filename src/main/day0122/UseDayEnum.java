package day0122;

public class UseDayEnum {
    public static void main(String[] args) {

        // Day enum의 모든 값
        for ( Day day : Day.values()){
            System.out.println(day);
        }
        System.out.println("-------------------");
        // 특정 값 하나 얻기
        System.out.println(Day.MON);
        // 특정 요소의 번호 : ordinal()
        System.out.println(Day.MON.ordinal());
        System.out.println(Day.TUE.ordinal());
        System.out.println(Day.WED.ordinal());


    }
}
