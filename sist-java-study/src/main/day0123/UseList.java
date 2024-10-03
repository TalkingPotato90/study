package day0123;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 모든 JDK버전에서는 Generic 없이 List를 생성하고 사용할 수 있다
 */
public class UseList {
    @SuppressWarnings("rawtypes")
    public UseList() {
        // 1. 생성 : Generic을 사용하지 않고 생성 => 모든 값을 추가할 수 있다
        List list = new ArrayList();

        // 2. 값 할당
        list.add(100); // 100 (기본형) -> autoboxing
        list.add(200);
        list.add(200);
        list.add(300);
        list.add(1.23);
        list.add("안녕하세요?");
        list.add(true);

        // 3.값 얻기
        for (int i = 0; i < list.size(); i++) {
            // 사용하는 쪽에서 에러가 발생할 수 있다.
//            System.out.println(((int) list.get(i)) * 10);
            System.out.println(list.get(i));
        }

        System.out.println(list + " / " + list.size());

        System.out.println("---------------------------------------------------");
        // Generic의 사용 : 입력 데이터형을 제한 (기본형 데이터형은 제네릭 사용 불가)
        List<Integer> list2 = new ArrayList<Integer>();

        // 값 할당
        list2.add(2024); // autoboxing = > list2.add(Integer.valueof(2024));
        list2.add(new Integer(1));
        list2.add(Integer.valueOf(23));
//        list2.add("안녕"); // 지정된 데이터형만 입력가능

        // 값 얻기
            int i = list2.get(0); // unboxing : list2.get(0).intvalue()
            int i2 = list2.get(1); // unboxing
            int i3 = list2.get(2).intValue();

        System.out.println( i + " / " + i2 + " / " + i3);

        for (int j = 0; j < list2.size(); j++) {
            System.out.println(list2.get(j)*10);
        }

        }

    public static void main(String[] args) {
        new UseList();
    }

}
