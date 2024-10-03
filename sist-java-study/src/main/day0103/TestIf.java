package day0103;

/**
 * 단일 if) - 조건에 맞을 때에만 코드를 실행해야 하는 경우<br>
 * 문법)<br>
 * if (조건식){<br>
 * 조건에 맞을 때 수행할 문장들...;<br>
 * }<br>
 */
public class TestIf {

    public static void main(String[] args) {
        // main method에 처음 입력된 arguments에 입력된 수의 절대값을 구하여 출력.
        int num = Integer.parseInt(args[0]);
        int abs = num;

        if (num < 0) {// 임의의 수가 0보다 작으면 음수이므로 true가 발생하고 if 탄다
            abs = -num; // 2의 보수연산을 수행
        }// end if
        System.out.println(num + "의 절대값 : " + abs);
        // 문자열의 비교는 "같은지만" 비교할 수 있고, 관계연산자를 사용하는 것이 아닌
        // equals method를 사용하여 비교한다.
        System.out.println("equals 문자열의 비교 : " + args[0].equals("-48"));
        System.out.println("equals 문자열의 비교 : " + args[0].equals("-47"));

        // main method에 두번째 입력된 arguments는 성별(여자, 남자)이다.
        // 프로그램의 출력은 출입문입장 > 여자인 경우 "수건 2장 지급" > 목욕탕입실의
        // 순서로 출력.

        System.out.println(args[1] + " 성별이 입력되었습니다.");
        System.out.println("출입문 입장.");
        if (args[1].equals("여자")) { // 문자열의 비교
            System.out.println("수건 2장 지급."); // 이 코드는 "여자"만 실행되어야한다.
        }
        System.out.println("목욕탕 입실");

        // 실수의 비교
        // 사람이 활동하기 좋은 날씨는 25.0 ~ 30.0도 이다. 이 온도일때만
        // "좋은 날씨입니다. ~(^^~)(~^^)~ " 를 출력.

        double temperature = 17.5;

        System.out.println("현재온도 : " + temperature);
        if (temperature > 25.0 && temperature <= 30.0) { // 25도 초과 30도 이하로 조건을 만들어보세요.
            System.out.println("좋은 날씨입니다. ~(^^~)(~^^)~ ");
        }

        // 문자의 비교
        // char의 변수에는 임의의 문자가 들어있다.
        // 해당 문자가 대문자일때만 "대문자"를 출력
        char temp = 'A';

        if (temp >= 65 && temp <= 90) {
            System.out.println("대문자");
        }


    }// main
}// class
