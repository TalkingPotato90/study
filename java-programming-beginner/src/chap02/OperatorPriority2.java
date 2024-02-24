package chap02;

public class OperatorPriority2 {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        System.out.println("-->복잡한 연산자 우선순위 실습<--");
        System.out.println("a = " + a + " b = " + b);
        System.out.println("++a = " + ++a);
        System.out.println("++a + b++ = " + ++a + b++);
        System.out.println("(++a % 3) + (a * ++b) = " + (++a % 3) + (a * ++b));

        int aa = 2, bb = 3, cc = 9, r1, r2, r3;
        System.out.println("aa = " + aa + " bb = " + bb + " cc = " + cc);
        r1 = ++aa + ++bb;
        r2 = cc++;
        r3 = b-- - ++aa + ++aa + bb--;
        System.out.println("\n++aa + ++bb = " + r1);
        System.out.println("cc++ = " + r2);
        System.out.println("b-- - ++aa + ++aa + bb-- = " + r3);
        System.out.println("aa = " + aa + " bb = " + bb + " cc = " + cc);
        System.out.println();
    }
}
