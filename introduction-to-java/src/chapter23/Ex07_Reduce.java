package chapter23;

import java.util.Arrays;
import java.util.List;

public class Ex07_Reduce {
    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("홍길동", "전우치", "손오공");

        // 초기값으로 주어진 글자 길이 3
        // 비교되는 글자의 길이도 전부 3이라 초기값이 남는다
        String name1 = list1.stream()
                .reduce("이순신",(s1,s2)->s1.length() >= s2.length()?s1 : s2);
        System.out.println(name1);

        List<String> list2 = Arrays.asList("홍길동","멀린","해리포터");

        // 초기값보다 긴 값이 존재
        String name2 = list2.stream()
                .reduce("이순신", (s1, s2) -> s1.length() >= s2.length()? s1 : s2);
        System.out.println(name2);
    }
}
