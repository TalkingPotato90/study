package chap03;

public class Return {
    public static void main(String[] args) {
        System.out.println("-->return 문의 실습<--");
        boolean t = true;
        System.out.println("return 문 발생 이전!!");
        if (t) {
            System.out.println("return 문 발생 프로그램종료!!\n");
            return;
        }
        System.out.println("이곳은 실행되지 않음!!");
    }
}
