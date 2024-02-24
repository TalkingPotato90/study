package chap02;

public class StringBinding {
    public static void main(String[] args) {
        // String형의 변수 disText를 작성하여 "안녕"으로 초기화
        String dispText = "안녕";
        System.out.println(dispText); // 안녕 으로 출력

        dispText = "하세요"; // dispText에 "하세요" 대입
        System.out.println(dispText); // 하세요 로 출력
        // 문자열은 + 연산자로 연결된다.

        String str1 = "안녕";
        String str2 = "하세요";
        System.out.println("str1 + str2 = " + str1 + str2); // 안녕하세요 로 출력

        // 또한 문자열에 정수형의 데이터를 + 연산자로 연결하면
        // 숫자는 문자열로 변환되어 연결된다

        int num1 = 2002;
        String str3 = "우리나라에 월드컵이 개최된 년도는? ";
        str3 = str3 + num1 + "년";
        System.out.println("str3 = " + str3);
    }
}
