package chap02;

public class OperatorPriority1 {
    public static void main(String[] args) {
        int x = 2, y = 3, z;
        // 연산자 우선순위가 높은 수식을 먼저 연산하고 그 결과를 z에 대입
        // 1. (y += 3)  2. ++x  3. y * 2  4. + 연산  5. - 연산  6. 마지막 - 연산
        z = x + y * 2 - ++x + (y += 3);
        System.out.println("-->간단한 연산자우선순위 실습<--");
        System.out.println("x : " + x + " y : " + y + " z :" + z + '\n');
        System.out.println("x / y * z : " + (x / y * z));
        System.out.println("x = y += z : " +(x = y += z));
        System.out.println();
    }
}
