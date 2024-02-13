package chap03;

public class NoForEach {
    public static void main(String[] args) {
        System.out.println("-->for~each 문과 배열 관련 실습<--\n");
        int nums[]={1,2,3,4,5,6,7,8,9,10};
        System.out.println("---데이터 값의 출력---");
        for(int x : nums){
            System.out.print(x + " ");
            x = x * 10; // nums 배열과 무관
        }

        System.out.println("\n");
        System.out.println("---배열 값의 출력---");
        for(int x : nums)
            System.out.print(x + " ");
        System.out.println("\n");
    }
}
