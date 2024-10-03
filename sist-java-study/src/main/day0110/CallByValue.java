package day0110;

/**
 * method의 매개변수가 기본형 데이터형을 사용하면 입력되는 값은 복사되어 들어간다<br>
 */
public class CallByValue {
    /**
     * i와 j를 입력받아서 두 변수의 값을 바꾸는 일
     *
     * @param i
     * @param j
     */
    public void swap(int i, int j) {
        int temp = 0;
        temp = i;
        i = j;
        j = temp;
        System.out.println("swap 안에서 i : " + i + ", j : " + j); // 1, 2024
    }

    public static void main(String[] args) {
        CallByValue cbv = new CallByValue();
        int i = 2024, j = 1;
        System.out.println("swap 전 i : " + i + ", j : " + j); // 2024, 1
        cbv.swap(i,j);
        System.out.println("swap 후 i : " + i + ", j : " + j); // 2024, 1

    }
}
