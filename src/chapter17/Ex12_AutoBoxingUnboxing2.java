package chapter17;

public class Ex12_AutoBoxingUnboxing2 {
    public static void main(String[] args) {
        // 오토 박싱
        Integer num = 10;

        // 래퍼 클래스에 증감 연상자 사용
        // Integer.valueOf(num.intValue() + 1);
        // 오토 박싱과 오토 언박싱 동시에 진행
        num++;

        System.out.println(num);

        // 래퍼 클래스에 복합 대입 연산자 사용
        // Integer.valueOf(num.intValue() + 3);
        num +=3;
        System.out.println(num);

        // 오토 언박싱 진행
        int r = num + 5;
        // 오토 언박싱 진행 + 오토 박싱 진행
        Integer rObj = num -5;

        System.out.println(r);
        System.out.println(rObj);
    }
}
