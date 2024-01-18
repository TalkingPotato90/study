package day0104;

/**
 * 다중 for : 인덱스를 두개 사용하여 반복해야 할 때 <br>
 * 문법)<br>
 * for (초기값 ; 조건식 ; 증감식){<br>
 * 반복수행문장 // 단일 for의 영역<br>
 * for (초기값 ; 조건식 ; 증감식){<br>
 * 반복수행문장 // 다중 for의 영역 <br>
 * }<br>
 * 반복수행문장 // 단일 for의 영역<br>
 * }
 */

public class TestFor2 {
    public static void main(String[] args) {

        // 다중 for의 동작 : 바깥 for가 한 번 반복할 때, 안쪽 for는 몇 번 반복하는가?
        for (int i = 0; i < 5; i++) { // 5번 반복
            for (int j = 0; j < 3; j++) { // 3번 반복
                System.out.printf("i : %d, j : %d%n", i, j);
            }
            System.out.println("-------------");
        }

        for (int i = 2; i < 10; i++) {
            System.out.printf("%d단%n", i);
            for (int j = 1; j < 10; j++) {
                System.out.printf("%d X %d = %d%n", i, j, i * j);
            }
            System.out.println("-----------");
        }

        // 안쪽 for가 0에서부터 시작하여 바깥 for의 현재 번째까지 반복
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.printf("%d %d ", i, j);
            }
            System.out.println();
        }

        // 안쪽 for의 시작이 바깥 for의 현재보다 1 큰 지점에서 반복
        System.out.println("--------------------");
        for (int i = 0; i < 5; i++) {
            for (int j = i + 1; j < 6; j++) {
                System.out.printf("%d %d ", i, j);
            }
            System.out.println();
        }

        System.out.println("--------------------");
        int k = 1;
        for (int i = 0; i < 4; i++) {
            for (int j =0 ; j <= i; j++) {
                System.out.printf("%d ",k++);
            }
            System.out.println();
        }

    }
}
