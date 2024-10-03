package day0115;

/**
 * 학생들의 점수를 처리하는 클래스
 */
public class UseArray2Work {
    public static final int KOREAN = 0;
    public static final int ENGLISH = 1;
    public static final int MATHEMATICS = 2;
    public static final int INDEX_TO_NUM = 1;
    int[][] scoreArr = {
            {89, 91, 86},
            {91, 93, 90},
            {98, 100, 99},
            {74, 85, 83},
            {88, 90, 95},
    };

    public void printScore() {

        String[] namesArr = {"루피", "샹디", "쵸파", "나미", "로빈"};

        int korScore = totalScore(subjectScoreArr(KOREAN));
        int engScore = totalScore(subjectScoreArr(ENGLISH));
        int mathScore = totalScore(subjectScoreArr(MATHEMATICS));

//        int[] korArr = {scoreArr[0][0], scoreArr[1][0], scoreArr[2][0], scoreArr[3][0], scoreArr[4][0]};
//        int[] engArr = {scoreArr[0][1], scoreArr[1][1], scoreArr[2][1], scoreArr[3][1], scoreArr[4][1]};
//        int[] matArr = {scoreArr[0][2], scoreArr[1][2], scoreArr[2][2], scoreArr[3][2], scoreArr[4][2]};

        System.out.printf("시험 응시 인원 [%d]명\n", namesArr.length);
        System.out.print("번호\t\t이름\t\t국어\t\t영어\t\t수학\t\t총점\t\t평균\n");
        System.out.println("-----------------------------------------------------");
        for (int i = 0; i < scoreArr.length; i++) {
            System.out.printf("%2d\t\t%s\t\t", i + INDEX_TO_NUM, namesArr[i]);
            for (int j = 0; j < scoreArr[i].length; j++) {
                System.out.printf("%3d\t\t", scoreArr[i][j]);
//                switch (j) {
//                    case 0 -> korScore += scoreArr[i][j];
//                    case 1 -> engScore += scoreArr[i][j];
//                    case 2 -> mathScore += scoreArr[i][j];
//                }
            }
//            korScore = totalScore(korArr);
//            engScore = totalScore(engArr);
//            mathScore = totalScore(matArr);
            System.out.printf("%d\t\t%d\n", totalScore(scoreArr[i]), totalScore(scoreArr[i]) / scoreArr[i].length);
        }

        System.out.println("------------------------------------------------------");
        System.out.printf("\t\t총점\t\t%d\t\t%d\t\t%d\n", korScore, engScore, mathScore); // 각 과목의 총점
        // 평균을 구할 과목의 숫자가 늘어나면 메서드 분리 고려
        System.out.printf("\t\t국어\t평균\t%.2f\n", (float) korScore / scoreArr.length); // 국어만 평균
        System.out.printf("1등 학생의 번호[%d], 이름[%s]", (checkWinnerIndex() + INDEX_TO_NUM), namesArr[checkWinnerIndex()]);
    }

    /**
     * 일차원 배열의 총점을 구하여 반환하는 일
     *
     * @return 총점
     */
    public int totalScore(int[] subjectScore) {
        int total = 0;
        for (int score : subjectScore) {
            total += score;
        }
        return total;
    }

    /**
     * 계산된 개인의 총점을 일차원 배열로 반환하는 일
     *
     * @return 총점의 배열
     */
    public int[] totalScoreArr() {
//        int[] totalArray = Arrays.stream(scoreArr).mapToInt(this::totalScore).toArray();
        int[] totalArray = new int[scoreArr.length];
        for (int i = 0; i < scoreArr.length; i++) {
            totalArray[i] = this.totalScore(scoreArr[i]);
        }
        return totalArray;
    }

    /**
     * 과목별 성적을 새로운 일차원 배열로 반환하는 일
     *
     * @param subject 상수 선언한 과목별 index
     * @return 과목별 성적 배열
     */
    public int[] subjectScoreArr(int subject) {
//        int[] subjectArray = Arrays.stream(scoreArr).mapToInt(i -> i[subject]).toArray();
        int[] subjectArray = new int[scoreArr.length];
        for (int i = 0; i < scoreArr.length; i++) {
            subjectArray[i] = scoreArr[i][subject];
        }
        return subjectArray;
    }

    /**
     * 개인별 총점을 기준으로 가장 높은 점수를 획득한 사람의 인덱스를 반환하는 일
     *
     * @return 1등의 인덱스
     */
    public int checkWinnerIndex() {
        int[] totalArray = this.totalScoreArr();
        int maxScore = totalArray[0];
        int winnerIndex = 0;
        for (int i = 0; i < totalArray.length; i++) {
            if (totalArray[i] > maxScore) {
                maxScore = totalArray[i];
                winnerIndex = i;
            }
        }
        return winnerIndex;
    }

//    public int[] korScoreArr() {
//        int[] korArray = new int[scoreArr.length];
//        for (int i = 0; i < scoreArr.length; i++) {
//            korArray[i] = scoreArr[i][0];
//        }
//        return korArray;
//    }
//
//    public int[] engScoreArr() {
//        int[] engArray = new int[scoreArr.length];
//        for (int i = 0; i < scoreArr.length; i++) {
//            engArray[i] = scoreArr[i][1];
//        }
//        return engArray;
//    }
//
//    public int[] mathScoreArr() {
//        int[] mathArray = new int[scoreArr.length];
//        for (int i = 0; i < scoreArr.length; i++) {
//            mathArray[i] = scoreArr[i][2];
//        }
//        return mathArray;
//    }


    public static void main(String[] args) {
        UseArray2Work uaw = new UseArray2Work();
        uaw.printScore();
    }

}
