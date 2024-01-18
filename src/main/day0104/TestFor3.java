package day0104;

/**
 * 다양한 for의 형태<br>
 * -무한 루프<br>
 * for(초기값; ; 증감식){<br>
 * }<br>
 * for( ; ; ){<br>
 * }
 */
public class TestFor3 {
    public static void main(String[] args) {

        // 증가하는 수를 세는 무한 루프
//        for (int i = 0; ; i++) {
//            System.out.println(i);
//            if (i == 50) {
//                break;
//            }
//        }

        // 증가하는 수를 세지 않는 무한 루프
        System.out.println("무한루프");

//        for (;;){
//            System.out.println("무한루프");
//        }

        // 여러개의 초기값을 가진 for
        for (int i = 0, j = 10, k = 100; i < 10; i++, j += 100, k--) {
            System.out.printf("i : %d, j : %d, k : %d%n",i,j,k);
        }

        // continue
        // 1에서부터 100까지 홀수만 출력
        for (int i = 1; i < 100 ; i++) {
            if (i % 2 == 0){
                continue;
            }
            System.out.printf("%d ",i);
        }
    }
}
