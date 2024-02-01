package chap02;

public class CastOperation {
    public static void main(String[] args) {
        System.out.println("--->형 변환의 실습 <---");
        // 실수를 정수로 형 변환하므로 소수이하 값이 잘림
        System.out.println("(int)7.9 = " + (int)7.9);
        System.out.println("(int)3.3 = " + (int)3.3);
        // 정수 또는 정수 연식식 결과를 실수로 형 변환하므로 강제로 . 이하 소수를 붙여서 나타남
        System.out.println("(double)(25) = " + (double)25);
        System.out.println("(double)(5 + 3) = " + (double)(5 + 3));
        System.out.println("(double)(15) / 2 = " + ((double)(15) / 2));
        System.out.println("(double)(15 / 2) = " + ((double)(15 / 2)));
        // 중복된 형 변환의 수식이 나타난 경우 우선적으로 괄호 안의 수식 결과로 나타나며,
        // 마지막에 표현된 형 변환의 결과로 변환되어 나타남
        System.out.println("(int)(7.8 + (double)(15) / 2) = "+((int)(7.8 + (double)(15) /2 )));
        System.out.println("(int)(7.8 + (double)(15 / 2)) = "+((int)(7.8 + (double)(15 /2 ))));
        System.out.println();
    }
}
