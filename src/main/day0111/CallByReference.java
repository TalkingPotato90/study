package day0111;

/**
 * method의 매개변수로 클래스가 정의되면 주소(유일)가 넘어간다
 */
public class CallByReference {

    int i;
    int j;

    public void swap(CallByReference cbr){
        int temp = 0;
        temp = cbr.i; // 2024
        cbr.i = cbr.j; // 1
        cbr.j =temp; //2024
        System.out.println("swap method 안 i : " +cbr.i+ ", j : " + cbr.j);
        }

    public static void main(String[] args) {
        CallByReference cbr = new CallByReference();
        cbr.i = 2024;
        cbr.j =1;

        System.out.println("swap method 전 i : " +cbr.i+ ", j : " + cbr.j);
        cbr.swap(cbr);
        System.out.println("swap method 후 i : " +cbr.i+ ", j : " + cbr.j);

    }
}
