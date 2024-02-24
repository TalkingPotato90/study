package chap03;

public class TopicFor {
    public static void main(String[] args) {
        System.out.println("-->다양한 for문의 실습<--\n");
        int a, b, i;
        System.out.println("----일반적인 For문 처리----");
        b = 4;
        for(a = 1; a < b; a++){
            System.out.println("a = " + a);
            System.out.println("b = " + b);
            b--;
        }

        System.out.println("\n----변수들의 다중 정의----");
        for(a = 1, b = 4; a < b; a++,b--){
            System.out.println("a = " + a);
            System.out.println("b = " + b);
        }

        System.out.println("\n----조건 없는 정의----");
        for(;;){
            a += 1;
            b += 1;
            System.out.println("a = " + a);
            System.out.println("b = " + b);
            // a가 5가 되면 for 문의 블록을 탈출
            if (a==5) break;
        }

        System.out.println("\n----목적값만 정의----");
        boolean done = false;
        i = 0;

        for(;!done;){
            System.out.println("i = " + i);
            if( i == 5) done = true;
            i++;
        }
        System.out.println();
    }
}
