package chap03;

public class IfElseIf {
    public static void main(String[] args) {
        System.out.println("-->if ~ else ~ if 문의 실습<--");
        int month = 4; // 봄
        String season;
        if (month == 12 || month == 1 || month == 2)
            season = "겨울";
        else if (month == 3 || month == 4 || month == 5)
            season = "봄";

        else if (month == 6 || month == 7 || month == 8)
            season = "여름";
        else if (month == 9 || month == 10 || month == 11)
            season = "가을";
        else
            season = "계절이 지정 안됨!!";

        System.out.println("4월은 " + season + "입니다!!!\n");
    }
}
