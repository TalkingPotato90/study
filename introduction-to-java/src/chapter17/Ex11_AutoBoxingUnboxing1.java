package chapter17;

public class Ex11_AutoBoxingUnboxing1 {
    public static void main(String[] args) {
        // 오토 박싱
        // 기본 자료형을 바로 래퍼 클래스형의 변수에 대입 가능
        Integer iObj = 10;
        Double dObj = 3.14;

        // 오토 언박싱
        // 래퍼 클래스형 변수를 기본 자료형의 변수에 대입 가능
        int num1 = iObj;
        double num2 = dObj;

        System.out.println(num1 + " : " + iObj);
        System.out.println(num2 + " : " + dObj);
    }
}
