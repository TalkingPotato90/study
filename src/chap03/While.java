package chap03;

public class While {
    public static void main(String[] args) {
        System.out.println("-->While문 실습<--");
        int n = 10;
        while (n > 0){
            System.out.println("n = " + n);
            n--;
        }
        System.out.println("While 그룹을 벗어난 후 n = " + n);
        System.out.println();
    }
}
