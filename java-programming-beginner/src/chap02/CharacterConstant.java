package chap02;

public class CharacterConstant {
    public static void main(String[] args) {
        char ch1, ch2, ch3;

        // 문자형 상수 대입
        ch1 = 88;
        ch2 = 'Y';
        System.out.println("-->문자형 상수의 표현<--");
        System.out.println("");

        System.out.println("ch1 = " + ch1);
        System.out.println("ch2 = " + ch2);
        // ch2의 문자형 상수가 'Y'인데 +1을 해서 형 변환 한 다음 'Z'로 결과 출력
        System.out.println("ch3 = " + (char)(ch2+1));
        System.out.println("");
    }
}
