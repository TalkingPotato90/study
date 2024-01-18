package day0116;

/**
 * 가변 배열 - 행마다 열의 개수가 다른 배열<br>
 * 사용법 : <br>
 * 1. 선언 : <br>
 * 데이터형[][] 배열명=null;<br>
 * 2. 생성 : 주의 - 행만 설정한다<br>
 * 배열명 = new 데이터형[행번호][];<br>
 * 3. 행마다 열 -&nbsp;일차원배열&nbsp;을 생성<br>
 * 배열명[행번호] = new 데이터형[열의 수];<br>
 * 4. 값 할당 : <br>
 * 배열명[행번호][열번호]=값;<br>
 * 5. 값 사용:<br>
 * 배열명[행번호][열번호];
 */
public class UseVariableArray {

    public UseVariableArray() {

        // 1. 선언
        int[][] arr2 = null;

        // 2. 생성 : 행의 수만 설정하여 생성
        arr2 = new int[5][];

        // 3. 행마다 열을 생성
        arr2[0] = new int[5];
        arr2[1] = new int[2];
        arr2[2] = new int[]{1, 2, 3, 4, 5, 6, 7};
//        arr2[3] = {1, 2, 3, 4, 5, 6, 7}; // 가변배열은 초기화시 생성코드 (new 데이터형)을 생략 할 수 없다
        arr2[3] = new int[]{1};
        arr2[4] = new int[]{1,2,3};

        // 4. 값 할당 : 행마다 열의 수가 다르므로 주의
        arr2[0][0]=2024;
        arr2[0][4]=42;
        arr2[1][0]=1;
        arr2[1][1]=16;

        // 5. 값 사용
        System.out.println(arr2[0][0]);

        // 일괄처리
        for (int i = 0; i < arr2.length; i++) {
//            System.out.printf("%d행의 열의 수 %d개\n", i, arr2[i].length);
            for (int j = 0; j < arr2[i].length; j++) {
                System.out.printf("%d\t",arr2[i][j]);
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        new UseVariableArray();
    }
}
