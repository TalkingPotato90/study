package chap02;

public class Printf1 {
    public static void main(String[] args) {
        double x = 15.674;
        double y = 235.73;
        double z = 9525.9864;
        System.out.println("-->printf 문의 출력 실습<--");
        System.out.println("x = " + x);
        System.out.println("y = " + y);
        System.out.println("z = " + z);

        System.out.println("\n소수이하 2자리 출력");
        // 본래의 값에서 소수이하 2자리로 출력
        System.out.printf("x = %.2f %n", x);
        System.out.printf("y = %.2f %n", y);
        System.out.printf("z = %.2f %n", z);

        System.out.println("\n소수이하 3자리 출력");
        System.out.printf("x = %.3f %n", x);
        System.out.printf("y = %.3f %n", y);
        System.out.printf("z = %.3f %n", z);
        System.out.println();
    }
}
