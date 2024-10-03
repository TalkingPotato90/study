package day1227;

class Exam1227 {
    public static void main(String[] args) {

        char firstInit = 'H';
        char secondInit = 'G';
        char thirdInit = 'D';

        int birthYear = 1990;
        int thisYear = 2023;

        System.out.println("내 이름은 홍길동 이고 이니셜은 " + firstInit + "," + secondInit + "," + thirdInit + "입니다.");
        System.out.println("태어난 해는 " + birthYear + "년으로\n나이는 " + (thisYear - birthYear) + "살 입니다.");

        double leftVision = 1.4;
        double rightVision = 1.5;

        System.out.println("왼눈 시력 " + leftVision + " 오른눈 시력 " + rightVision + "이고 양안 시력 " + ((leftVision + rightVision) / 2) + " 입니다.");

        int onewayCost = 1350;

        System.out.println("편도차비 " + onewayCost + "원 왕복차비는 " + (onewayCost * 2) + "원, 한달 20일 출근하면 월 교통비는 총 " + (onewayCost * 20) + "원 입니다.");

        char alphapet = 'A';

        System.out.println("대문자 \'" + alphapet + "\'의 Unicode 값은 " + (int) alphapet + "입니다. " + alphapet + "에 32 더하면 소문자 \'" + (char) (alphapet + 32) + "\'를 만들 수 있다.");

    } // main
} // class
