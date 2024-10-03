package day0123;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class UseSet {
    public UseSet() {
        // 1. 생성
        Set<String> set = new HashSet<String>();
        // 2. 값 할당 - 입력되는 값은 순차적으로 입력되지 않는다
        set.add("루피");
        set.add("쵸파");
        set.add("조로");
        set.add("나미");
        set.add("에이스");
        set.add("윤웅찬");
        set.add("김병년");

        // 중복값은 입력되지 않는다
        set.add("루피");
        set.add("나미");

        System.out.println(set.size());

        // 배열로 복사
        // 1. Set의 크기만큼 빈 배열을 생성
        String[] arr = new String[set.size()];
        // 2. set을 복사
        set.toArray(arr);

        // 삭제
//        set.remove("에이스");
//        set.clear();

        // 검색 => Iterator를 사용
        // 1. Iterator에 제어권을 할당
        Iterator<String> ita = set.iterator();
        // 2. 요소가 존재하는지 판단
        String temp = "";
        while (ita.hasNext()){
            temp = ita.next();
            System.out.println(temp);
        }

        System.out.println("---------------------");

        while (ita.hasNext()){
            temp = ita.next();
            System.out.println(temp);
        }

        System.out.println(set + " / " + set.size());
    }

    public static void main(String[] args) {
        new UseSet();
    }
}
