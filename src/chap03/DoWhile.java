package chap03;

public class DoWhile {
    public static void main(String[] args) {
        System.out.println("-->do~while 문의 실습<--");
        int n = 10;
        do{
            System.out.println("n = " + n);
            n--;
        } while (n > 0);
        System.out.println("do~while 그룹을 벗어난 후 n = " + n);
        System.out.println();
    }
}
