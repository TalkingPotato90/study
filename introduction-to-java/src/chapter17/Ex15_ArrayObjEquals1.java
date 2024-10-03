package chapter17;

import java.util.Arrays;

class INum1{
    private int num;

    public INum1(int num){
        this.num = num;
    }
}
public class Ex15_ArrayObjEquals1 {
    public static void main(String[] args) {
        INum1[] arr1 = new INum1[2];
        INum1[] arr2 = new INum1[2];

        // 두 배열에 동일한 값으로 초기화
        arr1[0] = new INum1(1);
        arr2[0] = new INum1(1);

        arr1[1] = new INum1(2);
        arr2[1] = new INum1(2);

        // 배열 비교 결과 출력
        // 객체의 내용이 아닌 참조값의 비교이므로 false
        System.out.println(Arrays.equals(arr1, arr2));
    }
}
