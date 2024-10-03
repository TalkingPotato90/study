package day0104;

/**
 * for문 : 시작과 끝을 알때 사용하는 반복문 <br>
 * 문법)<br>
 * for (시작값 ; 조건식 ; 증감식){<br>
 * 반복수행될 문장들...;<br>
 * }
 */

public class TestFor {
    public static void main(String[] args) {

        // 안녕하세요를 10번 출력하는 코드 작성,
        for (int i = 0; i < 10; i++) {
            System.out.println("안녕하세요? " + i);
        }

        // 1에서부터 100까지 옆으로 출력하는 코드 작성
        for (int i = 1; i < 101; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        // 1에서부터 100까지 홀수만 옆으로 출력하는 코드 작성
        int cnt = 0;
        // 증감식은 대상체의 값을 변화시키고 저장할 수 있는 모든 연산자를 사용할 수 있다
        for (int i = 1; i < 100; i += 2) {
            cnt++;
            System.out.print(i + " ");
        }
        System.out.println("\n" + cnt + "번");
        System.out.println();

        // 100에서부터 1까지 옆으로 출력하는 코드 작성
        for (int i = 100; i > 0; i--) {
            System.out.print(i + " ");
        }
        System.out.println();

        // 1에서부터 9까지 1씩 증가하는 값을 아래로 출력
        for (int i = 1; i < 10; i++) {
            System.out.println("4 X " + i + " = " + (i * 2));
        }

        System.out.println("------------------------------------");

        // main method에서 처음 입력된 값이 구구단의 범위 였을 때 (2 ~ 9)
        // 해당 단의 구구단을 출력하는 코드 작성
        int gugu = Integer.parseInt(args[0]);
        if (gugu > 1 && gugu < 10) {
            for (int i = 1; i < 10; i++) {
                System.out.println(gugu + " X " + i + " = " + (gugu * i));
            }
        } else {
            System.out.println("유효한 숫자가 아닙니다.");
        }

        // 1에서부터 100까지의 합을 출력. 5050
        int sum = 0; // 누적합을 하기 위한 변수
        for (int i = 1; i < 101; i++) {
            sum += i;
        }
        System.out.println("1~100까지의 합은 " + sum);
    }
}
