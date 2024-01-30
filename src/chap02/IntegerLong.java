package chap02;

/*
    long형을 이용한 거리의 계산
    IntegerLong.java
 */
public class IntegerLong {
    public static void main(String[] args) {
        // 정수형 변수 선언
        int lightspeed;
        long days;
        long seconds;
        long distance;

        // 초당 마일의 속도 값 정의
        lightspeed = 186000;

        days = 1000; // 날짜 선언

        seconds = days * 24 * 60 * 60; // 초값 계산

        distance = lightspeed * seconds; // 거리 계산

        // 결과 출력
        System.out.print(days + " 일 동안 여행한 거리는 ");
        System.out.println(distance + " 마일 입니다.");
    }
}
