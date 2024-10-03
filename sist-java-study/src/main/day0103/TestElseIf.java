package day0103;

/**
 * 다중 if (else ~ if) : 연관된 여러 조건을 비교할 때 사용<br>
 * 문법)<br>
 * <p>
 * if (조건식){<br>
 * 조건에 맞을 때 수행할 문장들...;<br>
 * } else if (조건식) {<br>
 * 조건에 맞을 때 수행할 문장들...;<br>
 * .<br>
 * .<br>
 * .<br>
 * }else{<br>
 * 조건에 맞지 않을 때 수행할 문장들...;<br>
 * }
 */
public class TestElseIf {

    public static void main(String[] args) {
        // *점수판별
        // 점수는 0보다 작을 수 없고, 100보다 클 수 없다.
        // 0보다 작다면 "0보다 작아서 실패!!!" 출력하고,
        // 100보다 크다면 "100보다 커서 실패!!!" 출력하고,
        // 그렇지 않다면 (0 ~ 100 사이) "성공!!!"을 출력

        int score = 101;

        System.out.println(score + "점은 ");
        if (score < 0) {
            System.out.println("0보다 작아서 실패!!!");
        } else if (score > 100) {
            System.out.println("100보다 커서 실패!!!");
        } else {
            System.out.println("성공!!!");
        }

        // char 형의 변수에는 임의의 문자가 할당되어있다.
        // 할당된 문자가 "대문자 -65 "인지, "소문자 -97"인지, "숫자 -48"인지 그렇지 않다면
        // "영어나 숫자가 아닙니다." 를 출력하는 코드를 작성

        char tempChar = '1';

        if (tempChar > 64 && tempChar < 91) {
            System.out.println("대문자");
        } else if (tempChar > 96 && tempChar < 123) {
            System.out.println("소문자");
        } else if (tempChar > 47 && tempChar > 58) {
            System.out.println("숫자");
        } else {
            System.out.println("영어나 숫자가 아닙니다.");
        }

        // 태어난 해를 저장하는 변수를 선언하고, 자신의 태어난 해를 할당한다.
        // 태어난 해의 띠를 출력하세요.
        // 0-원숭이, 1-닭, 2-개, 3-돼지, 4-쥐, 5-소, 6-호랑이, 7-토끼, 8-용,
        // 9-뱀, 10-말, 11-양

        int birth = 1990;
        System.out.println(birth + " 해는 " /* + (birth % 12) */);

        if (birth % 12 == Zodiac.MONKEY) {
            System.out.println("원숭이");
        } else if (birth % 12 == Zodiac.ROOSTER) {
            System.out.println("닭");
        } else if (birth % 12 == Zodiac.DOG) {
            System.out.println("개");
        } else if (birth % 12 == Zodiac.PIG) {
            System.out.println("돼지");
        } else if (birth % 12 == Zodiac.RAT) {
            System.out.println("쥐");
        } else if (birth % 12 == Zodiac.OX) {
            System.out.println("소");
        } else if (birth % 12 == Zodiac.TIGER) {
            System.out.println("호랑이");
        } else if (birth % 12 == Zodiac.RABBIT) {
            System.out.println("토끼");
        } else if (birth % 12 == Zodiac.DRAGON) {
            System.out.println("용");
        } else if (birth % 12 == Zodiac.SNAKE) {
            System.out.println("뱀");
        } else if (birth % 12 == Zodiac.HORSE) {
            System.out.println("말");
        } else if (birth % 12 == Zodiac.LAMB) {
            System.out.println("양");
        }

    }

}
