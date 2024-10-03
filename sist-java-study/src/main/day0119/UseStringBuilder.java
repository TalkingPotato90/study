package day0119;

public class UseStringBuilder {
    public void useStringBuffer() {
        // 1. 객체화
        StringBuffer sb = new StringBuffer();

        // 2. 객체가 제공하는 method 사용
        // 값을 sb객체 참조하는 공간에 추가
        sb.append("안녕");
        sb.append(true);
        sb.append(2024);

        // 특정 위치에 값 추가
        sb.insert(6,"수원시의 자랑 윤웅찬");

        // 특정 범위의 값 삭제 : delete(시작인덱스, 끝인덱스+1)
        sb.delete(11,14);

        sb.delete(0,sb.length());
        sb.append("hello");

        String reformSb = sb.toString();
        // sb가 참조하는 메모리에는 hello 들어있는지 비교하는 코드 작성. hello와 같으면 true!!
        System.out.println(reformSb.equals("hello"));
        // sb에는 hello가 소문자로 들어가 있다 >> 대문자로 출력
        System.out.println(reformSb.toUpperCase());
        System.out.println(sb);// 1. 객체화

    }

    public void useStringBuilder() {
        StringBuilder sb = new StringBuilder();

        // 2. 객체가 제공하는 method 사용
        // 값을 sb객체 참조하는 공간에 추가
        sb.append("안녕");
        sb.append(true);
        sb.append(2024);

        // 특정 위치에 값 추가
        sb.insert(6,"수원시의 자랑 윤웅찬");

        // 특정 범위의 값 삭제 : delete(시작인덱스, 끝인덱스+1)
        sb.delete(11,14);

        sb.delete(0,sb.length());
        sb.append("hello");

        String reformSb = sb.toString();
        // sb가 참조하는 메모리에는 hello 들어있는지 비교하는 코드 작성. hello와 같으면 true!!
        System.out.println(reformSb.equals("hello"));
        // sb에는 hello가 소문자로 들어가 있다 >> 대문자로 출력
        System.out.println(reformSb.toUpperCase());

        System.out.println(sb);
    }

    public static void main(String[] args) {
        UseStringBuilder usb = new UseStringBuilder();
        System.out.println("--------------StringBuffer---------------");
        usb.useStringBuffer();

        System.out.println("--------------StringBuilder--------------");
        usb.useStringBuilder();

        String str="안녕";
        // String에 +=을 사용하거나 +연산 하게되면 JDK1.5에서부터는
        // StringBuilder객체를 생성하여 문자열 저장하고 append를 수행한다
        str+="하세요?";
        str+="오늘은";
        System.out.println(str+" 추운 월요일 입니다."+ "아우 춥다");

        StringBuilder sb = new StringBuilder("안녕");
        sb.append("하세요?").append("오늘은");
        System.out.println(sb.append(" 추운 월요일 입니다").append(" 아우 춥다"));
    }
}
