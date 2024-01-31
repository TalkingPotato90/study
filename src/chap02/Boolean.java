package chap02;

public class Boolean {
    public static void main(String[] args) {
        boolean b;
        b = false;
        System.out.println("-->논리형 연산<--");
        System.out.println("b = " + b);
        b = true;
        System.out.println("b = " + b);

        // boolean 값은 if문에 의해 제어된다
        if (b) System.out.println("true인 경우 실행된다.");

        b = false;
        if (b) System.out.println("false인 경우 실힝이 안된다");

        // 관계식이 발생한 경우 논리값이 발생된다
        System.out.println("10 > 9 -> " + (10 > 9));
        System.out.println();
    }
}
