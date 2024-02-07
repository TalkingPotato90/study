package chap03;

public class NestedSwitch {
    public static void main(String[] args) {
        System.out.println("-->nested switch 문의 실습<--");

        int i = 0;
        switch (i){
            case 0:
                int j = 1;
                switch (j){
                    case 0:
                        System.out.println("i = 0, j = 0"); break;
                    case 1:
                        System.out.println("i = 0, j = 1"); break;
                    default:
                        System.out.println("내포된 default case!!");
                }
                break;
            default:
                System.out.println("case에서 발견되지 않았음!!");
        }
        System.out.println();
    }
}
