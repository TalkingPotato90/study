package chapter14;

public class Ex08_StringBuilder {
    public static void main(String[] args) {
        StringBuilder buf = new StringBuilder("동해물과");

        buf.append("백두산이");
        // 형변환 후 출력
        System.out.println(buf.toString());

        // 추가
        buf.append(12345);
        System.out.println(buf.toString());

        // 구간 삭제
        buf.delete(0,4);
        System.out.println(buf.toString());

        // 값 변경
        buf.replace(4,8,"ABC");
        System.out.println(buf.toString());

        // 순서 반전
        buf.reverse();
        System.out.println(buf.toString());

    }
}
