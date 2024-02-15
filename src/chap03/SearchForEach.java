package chap03;

public class SearchForEach {
    public static void main(String[] args) {
        int nums[]={6,8,3,7,5,6,1,4};
        int val =5; int idx =1;
        System.out.println("-->for~each 문으로 배열 데이터 검색 실습<--");
        boolean found = false;

        // x 값이 배열의 개수만큼 수행되나 5번째 변수에서 if문에 의해 블록을 빠져나감
        for(int x : nums){
            if (x == val) {
                found = true;
                break;
            }
            idx++;
        }
        if(found)
            System.out.println(idx + "번째 위치의"+ nums[idx-1]+"값을 발견했습니다!!");
        System.out.println();
    }
}
