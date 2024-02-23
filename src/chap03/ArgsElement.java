package chap03;

public class ArgsElement {
    public static void main(String[] args) {
        System.out.println("-->인수 내용 묻기<--");
        for (int i = 0; i < args.length; i++) {
            System.out.println("args의 "+i+"번째 요소 : "+args[i]);
        }
        System.out.println();
    }
}
