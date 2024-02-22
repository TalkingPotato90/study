package chap03;

public class ThreeArray {
    public static void main(String[] args) {
        int[][][]a = new int[2][][]; // a[0], a[1]
        System.out.println("-->3차원 배열의 출력 실습<--");
        a[0]=new int[2][]; // a[0][0], a[0][1]
        a[1]=new int[3][]; // a[1][0], a[1][1], a[1][2]
        a[0][0]=new int[4]; // a[0][0][0], a[0][0][1], a[0][0][2], a[0][0][3]
        a[0][1]=new int[4]; // a[0][1][0], a[0][1][1], a[0][1][2], a[0][1][3]
        a[1][0]=new int[3];
        a[1][1]=new int[3];
        a[1][2]=new int[3]; // a[1][2][0], a[1][2][1], a[1][2][2]
        a[0][0][0]=10;
        a[1][1][1]=20;

        System.out.println(a.length);
        System.out.println(a[1].length);
        System.out.println(a[1][2].length);
        System.out.println(a[1][1][1]);
        System.out.println();
    }
}
