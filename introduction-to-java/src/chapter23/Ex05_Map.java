package chapter23;

import java.util.Arrays;
import java.util.List;

public class Ex05_Map {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple", "banana", "orange");
        // 컬렉션 프레임워크에 구현된 스트림을 만들 수 있는 메서드
        list.stream()
                // 데이터를 하나씩 받아 대문자로 데이터 변환
                .map(s -> s.toUpperCase())
                .forEach(n-> System.out.print(n + "\t"));

        System.out.println();

    }
}
