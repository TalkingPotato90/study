package chap03;

public class ForEach {
    public static void main(String[] args) {
        // 배열에서 초기값을 지정한만큼 선언
        int nums[] = {1,2,3,4,5,6,7,8,9,10};
        System.out.println("-->for~each 문의 실습<--");
        int sum = 0;
        // x에 nums 배열의 값이 차례대로 대입되어 수행됨
        for(int x : nums){
            // x 값을 출력하고 sum에 각각의 값을 누적함
            System.out.println("x = " + x);
            sum += x;
        }
        System.out.println("\n합계 = " +sum);
        System.out.println();
    }
}
