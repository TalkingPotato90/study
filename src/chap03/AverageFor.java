package chap03;

public class AverageFor {
    public static void main(String[] args) {
        double nums[] ={10.1, 11.2, 12.3, 13.4, 14.5};
        double result = 0;
        int i;
        System.out.println("-->for 문으로 1차원 배열 테이터 실습<--");
        for (i = 0; i < 5; i++)
            result = result + nums[i];
        System.out.println("배열값의 평균 = "+result/nums.length);
        System.out.println();
    }
}
