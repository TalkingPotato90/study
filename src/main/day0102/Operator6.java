package day0102;

/*
삼항(조건)연산자
전항 ? 항1 : 항2
*/
class Operator6 {
    public static void main(String[] args) {
        int num = 1;
        System.out.println(num + "은(는) " + (num >= 0 ? "양수" : "음수"));

        num = 2;
        // num이 홀수인지 짝수인지를 판단하여 출력하는 코드
        System.out.println(num + "은(는) " + (num % 2 == 0 ? "짝수" : "홀수"));

        //점수를 저장하는 변수를 선언하고, 임의의 값을 할당한다.
        //할당된 값이 0~100 사이라면 "유효점수"를 출력하고,
        //그렇지 않다면 "무효점수"를 출력하는 코드를 작성.
        // -1, 0 ~ 100, 101 : 경계값 테스트

        int score = 101;

        System.out.println(score + "점은 " +
                (score >= 0 && score <= 100 ? "유효점수" : "무효점수"));

        System.out.println(score + "점은 " +
                (score > -1 && score < 100 ? "유효점수" : "무효점수"));
    } // main
} // class
