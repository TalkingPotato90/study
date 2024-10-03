package chapter15;

public class Ex03_StringArray {
    public static void main(String[] args) {
        // String형 데이터를 저장할 배열을 선언
        String[] name = new String[7];

        // 문자열 리터럴 대입이 아닌 new 연산자 사용
        name[0] = new String("홍길동");
        name[1] = new String("전우치");
        name[2] = new String("손오공");
        name[3] = new String("강감찬");
        name[4] = new String("이순신");
        name[5] = new String("을지문덕");
        name[6] = new String("양만춘");

        int cnum = 0;

        // 배열 neme의 요소 개수만큼 반복문으로 반복
        for (int i = 0; i < name.length; i++) {
            System.out.println(name[i]);
            // 각 문자열의 길이를 구해서 합산
            cnum += name[i].length();
        }
        System.out.println("총 문자의 수 : " + cnum);
    }
}
