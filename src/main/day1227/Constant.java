package day1227;

/*
Constant : 변수를 상수처럼 사용할 때 사용.
*/
class Constant {

    public static final int MAX_SCORE = 100; // 기준값
    public static final int MIN_SCORE = 0;

    public static void main(String[] args) {


        int myScore = 80;
        //MAX_SCORE = 99; // constant는 값을 변경할 수 없다.

        System.out.println("최고점수와 획득점수간의 차 " + (MAX_SCORE - myScore));

        System.out.println("최고점수와 획득점수간의 차 " + (Constant.MAX_SCORE - myScore));
    } // main
} // class

