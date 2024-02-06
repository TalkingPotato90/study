package chap03;

public class SimpleIfBlock {
    public static void main(String[] args) {
        System.out.println("-->단순 if문의 실습<--");
        int x = 5;
        // x가 0보다 클 경우 6~7번 문장을 수행
        if (x > 0){
            System.out.println("x는 양수입니다!!");
            System.out.println("x = " + x);
        }
        System.out.println();
    }
}
