package chapter14;

import java.util.StringTokenizer;

public class Ex09_StringTokenizer {
    public static void main(String[] args) {
        // 두 번째 매개 변수가 없으면 공백 기준 분할
        StringTokenizer st1 = new StringTokenizer("a b c");
        // StringTokenizer st2 = new StringTokenizer("1,2,3",",");

        // 토큰 유무 확인
        while (st1.hasMoreTokens()){
            System.out.println(st1.nextToken());
        }
    }
}
