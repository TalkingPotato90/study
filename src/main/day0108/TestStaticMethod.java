package day0108;

/**
 * static method 작성
 */
public class TestStaticMethod {

    public static void plus(int num, int num2) {
        int result = 0;
        result = num + num2;
        System.out.println(result);
    }

    // 구구단을 입력받아 구구단의 범위였을 때 출력하는 method 작성, 호출
    public static void gugudan(int guguNum) {
        if (guguNum >= 2 && guguNum <= 9) {
            for (int i = 1; i < 10; i++) {
                System.out.printf("%d X %d = %2d\n", guguNum, i, guguNum * i);
            }
        } else {
            System.out.println("구구단의 범위가 아닙니다.");
        }
    }

    public static void main(String[] args) {
        // 객체화 없이 바로 호출 가능
        TestStaticMethod.plus(1, 8);
        TestStaticMethod.gugudan(2);
    }
}
