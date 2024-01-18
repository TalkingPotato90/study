package day0112;

/**
 * 일차원 배열 : 열로만 구성된 배열<br>
 * 1. 선언 : <br>
 * 데이터형[] 배열명 = null;<br>
 * 2. 생성 : <br>
 * 배열명 = new 데이터형[방의 크기];<br>
 * 1 + 2. 데이터형[] 배열병 = new 데이터형[방의 크기];<br>
 * 3. 값 할당 : 존재하지 않는 배열 인덱스를 사용하면 error 발생<br>
 * 배열명[방의 번호] = 값;<br>
 * 4. 값 사용 :<br>
 * 배열명[방의 번호]<br>
 * 일괄처리 (한번에 처리)<br>
 * - 방의 수 : 배열명.length<br>
 * for (int i = 0; i < 배열명.length; i++){<br>
 * 배열명[i];<br>
 * }
 */
public class UseArray1 {
    public UseArray1() {
        // 1. 선언
        int[] arr = null;
        // 2. 생성 : heap에 생성되고, 모든 방의 값은 0으로 초기화된다.
        arr = new int[5];
        // 3. 값 할당
        arr[0] = 2024;
        arr[1] = 1;
        arr[2] = 12;
        arr[3] = 14;
        arr[4] = 44;
//        arr[5] = 1; // 존재하지 않는 인덱스를 사용하면 error

        System.out.println(arr + ", 방의 수 : " + arr.length + "개");
        System.out.println("처음 방 : " + arr[0] + ", 두번재 방 : " + arr[1]);

        // 4. 값 얻기
        System.out.println(arr[0] + " ~ " + arr[4]);

        // 5. 일괄 처리 (한꺼번에 처리)
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d] = %d\n", i, arr[i]);
            sum += arr[i];
        }

        System.out.println(sum);

    }

    public void scoreProcess() {
        System.out.println("--------------------------------------------");
        String[] nameArr = {"루피", "샹크스", "나미", "조로", "쵸파"};
        String[] addrArr = {"서울시 강남구 역삼동", "서울시 동대문구 동대문동",
                "인천시 미추홀구", "서울특별시 구로구 구로동", "수원시 영통구 영통동"};
        int[] scoreArr = {94, 96, 75, 83, 100}; // new int[]을 생략
//        int[] scoreArr = new int[]{94, 96, 75, 83, 100}; // new int[] 명시
//        int scoreArr = new int[5]{94, 96, 75, 83, 100}; // 방의 크기를 지정하면 error

        System.out.printf("번호\t 이름\t점수\t\t\t\t주소\n");
        int totalScore = 0;
        float avgScore = 0.0f;
        int cnt = 0;

        for (int i = 0; i < nameArr.length; i++) {
            if (addrArr[i].contains("서울")) {
                System.out.printf("%2d\t%3s\t%3d\t\t%s\n", i + 1, nameArr[i], scoreArr[i], addrArr[i]);
                totalScore += scoreArr[i];
                cnt++;
            }
            avgScore = (float) totalScore / cnt;
        }

        System.out.println("------------------------------------");

        System.out.printf("총점 [%d]점 평균[%.2f]점\n", totalScore, avgScore);

        System.out.println("------------------------------------");

        // scoreArr의 마지막번째 방부터 출력
        for (int i = scoreArr.length - 1; i > -1; i--) {
            System.out.println(scoreArr[i]);
        }
        System.out.println("------------------------------------");

        // Flowchart를 코드로 옮겨보세요
        int top = scoreArr[0];
        int bottom = scoreArr[0];
        for (int i : scoreArr) {
            if (top < i) {
                top = i;
            }
        }
        for (int i : scoreArr) {
            if (bottom > i) {
                bottom = i;
            }
        }
        System.out.println("최고 점수 : " + top + "점");
        System.out.println("최저 점수 : " + bottom + "점");

        System.out.println("------------------------------------");

        // Flowchart를 코드로 옮겨보세요
        int temp =0;
        for (int i = 0; i < scoreArr.length-1; i++) {
            for (int j = i + 1; j < scoreArr.length; j++) {
                if(scoreArr[i] < scoreArr[j]){
                    temp = scoreArr[i];
                    scoreArr[i] = scoreArr [j];
                    scoreArr[j] = temp;
                }
            }
        }
        for (int i : scoreArr) {
            System.out.println(i);
        }


    }

    public static void main(String[] args) {
        new UseArray1().scoreProcess();
    }
}
