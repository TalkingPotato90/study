package day0108;

/**
 * 시작과 끝을 모를 때 사용하는 반복문<br>
 * 최소 0번 수행에서 부터 최대 조간까지 수행<br>
 * 문법)<br>
 * while(조건식){<br>
 * 반복수행문장들...;<br>
 * }
 */
public class TestWhile {
    public static void main(String[] args) {

        int i = 0; // 초기값

        while (i < 10) { // 조건식
            System.out.println("i = " + i); // 반복수행 문장들
            i++; // 증감식
        }


        // 구구단 5단 출력
        i = 5;
        int j = 1;
        while (i == 5) {
            while (j < 10) {
                System.out.println(i + " X " + j + " = " + (i * j));
                j++;
            }
            i++;
        }
    }
}
