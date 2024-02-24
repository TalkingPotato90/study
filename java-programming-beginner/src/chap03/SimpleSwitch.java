package chap03;

public class SimpleSwitch {
    public static void main(String[] args) {
        int i = 3;
        System.out.println("-->단순 switch 문의 실습<--");
        switch (i) {
            case 0:
                System.out.println("i = 0");
                break;
            case 1:
                System.out.println("i = 1");
                break;
            case 2:
                System.out.println("i = 2");
                break;
            case 3:
                System.out.println("i = 3");
                break;
            default:
                System.out.println("i > 3");
        }
        System.out.println();
    }
}
