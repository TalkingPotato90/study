package chap02;

public class TotalInteger {
    public static void main(String[] args) {
        System.out.println("-->각종 정수의 실습<--");

        // 10진 정수와 8진 정수 그리고 16진 정수값을 선언한다
        int a = 255, b= 0417, c = 0xaff;

        // 16진 정수를 long의 형으로 d의 변수에 대입한다
        long d = 0xaffL;

        // a, b, c, d의 값을 출력한다
        System.out.println("\na = " +a+", b =" +b+"\nc = " +c+", d = "+d);

        /*
        c와 d의 값을 비교하여 같으면 Yes를 출력하고
        아니면 No를 출력하며, 여기서는 c와 d의 변수형이
        다르지만 저장되어 있는 값은 같으므로 Yes를 출력한다
        [실수의 경우 부동소수점의 사용을 실제 값이 다르게 저장될 수 있지만
        정수의 경우 해당 값이 그대로 저장되므로 결과는 Yes]
         */
        if (c == d) System.out.println(("c == d -> Yes"));
        else System.out.println(("c == d -> No"));
        System.out.println();
    }
}
