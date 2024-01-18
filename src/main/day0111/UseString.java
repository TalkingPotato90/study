package day0111;

/**
 * 문자열의 사용<br>
 * 문자열 저장소에 저장된 시작주소를 저장하고 사용하기 위한 데이터형으로 java.lang.String<br>
 * 클래스(참조형데이터형 - new 해서 사용)를 제공한다
 */
public class UseString {
    public static void main(String[] args) {
        // 기본형 형식의 사용 : new ❌
        String str = "ABCDE";
        // 참조형 형식의 사용 : new ⭕
        String str1 = new String("ABCDE");

        System.out.println("기본형 형식 : " + str);
        System.out.println("참조형 형식 : " + str1);

        // == 비교 : 기본형 형식과 참조형 형식이 다른 결과를 반환한다
        System.out.println("기본형 형식 " + (str == "ABCDE")); // true
        System.out.println("참조형 형식 " + (str1 == "ABCDE")); // false

        // equals 비교 : 기본형 형식과 참조형 형식이 같은 결과를 반환한다
        System.out.println("기본형 형식 " + (str.equals("ABCDE"))); // true
        System.out.println("참조형 형식 " + (str1.equals("ABCDE"))); // true

        System.out.println(str + "은 " + str.length() + "자");
        str1 = "star901210@hanmail.net";
        int leng = str1.length();
        System.out.printf("%s는 %d자\n", str1, leng);

        str = "abCedF";
        System.out.println(str + "을 모두 대문자로 : " + str.toUpperCase());
        System.out.println(str + "을 모두 소문자로 : " + str.toLowerCase());

        System.out.println(str + "에서 3번째 인덱스의 문자 : " + str.charAt(3));
        char c = str.charAt(1);
        System.out.println(str + "에서 1번째 인덱스의 문자 : " + c);

        // 자신의 메일 주소에서 @을 변수에 저장하여 출력
        c = str1.charAt(10);
        System.out.println(c);

        // 문자열안에서 특정 문자열의 시작 인덱스를 얻기 (L -> R)
        str = "Java Oracle JDBC";
        System.out.println(str + "에서 'r'의 인덱스 " + str.indexOf("r"));
        System.out.println(str + "에서 \"Ora\"의 인덱스 " + str.indexOf("Ora"));
        // 존재하지 않는 문자열은 -1이 나온다.
        System.out.println(str + "에서 \"ora\"의 인덱스 " + str.indexOf("ora"));
        // 같은 문자열이 있다면 처음 문자열의 인덱스만 나온다
        System.out.println(str + "에서 두번째 \"a\"의 인덱스 " + str.indexOf("a", str.indexOf("a") + 1));
        // 문자열안에서 특정 문자열의 시작 인덱스를 얻기 (R -> L)
        System.out.println(str + "에서 뒤에서 부터 찾은 'a'의 인덱스 " + str.lastIndexOf("a"));

        String str2 = str.concat(" HTML"); // 문자열 합치기
        System.out.println(str2);
        // Java Oracle JDBC HTML
        String str3 = str2.substring(5,11); // Oracle
        System.out.println(str3);

        // str1 = "star901210@hanmail.net";
        // str1에서 메일 주소 (로컬 파트)를 잘라내어 출력
        // str1에서 도메인파트(TLD - Top Level Domain)를 잘라내어 출력
        System.out.println("메일 주소 : " + str1.substring(0,str1.indexOf("@")));
        System.out.println("도메인 주소 : " + str1.substring(str1.indexOf("@")+1,str1.length()));
        // 시작인덱스만 설정하면 끝까지 잘라낸다
        System.out.println("도메인 주소 : " + str1.substring(str1.indexOf("@")+1));

        boolean flag = str2.startsWith("Java");
        System.out.println(str2+"은 Java로 시작했는가? " + flag);

        boolean flag2 = str2.startsWith("java");
        System.out.println(str2+"은 java로 시작했는가? " + flag2);

        String name="홍길동";
        if (name.startsWith("김")){
            System.out.println(name + "님은 '김'씨 입니다.");
        } else {
            System.out.println(name + "님은 '김'씨가 아닙니다.");
        }

        String addr = "서울시 강남구 역삼동";
        if(addr.endsWith("동")){
            System.out.println("도시");
        } else {
            System.out.println("시골");
        }

//        str3 = "오늘은 Java를 공부하였다.";
//        str3= "Java는 WORA가 특징인 완벽한 OOP언어입니다.";
        str3= "오늘도 긴시간 함께 공부하시느라 고생 많으셨Java.";

        if(str3.contains("Java")) {
            System.out.println(str3 + " 안에는 \"Java\"가 포함되어 있음");
        }else {
            System.out.println(str3 + " 안에는 \"Java\"가 없음");
        }

        String mail1 = "test@test.com";
        String mail2 = "testtest.com";
        String mail3 = "test@testcom";

        UseString us = new UseString();
        us.validateEmail(mail1);
        us.validateEmail(mail2);
        us.validateEmail(mail3);
    }

    // mail 주소를 입력방아 유효한 메일인지, 무효한 메일인지를 판단하는 method 작성
    // 유효한 메일은 7자 이상이면서 @과 .이 포함되어야 한다. 그러면 유효 메일을 출력,
    // 그렇지 않으면 무효메일 출력

    public void validateEmail(String email) {
        System.out.println(email);
        int mailLength = email.length();
        int mailForm1 = email.indexOf("@");
        int mailForm2 = email.indexOf(".");
        String result = "유효 메일";
        if (mailLength < 7 || mailForm1 == -1 || mailForm2 == -1) {
            result = "무효 메일";
        }
        System.out.println(result);
    }

}
