package day0122;

import java.text.DecimalFormat;

public class UseDecimalFormat {
    public UseDecimalFormat() {
        int i=9_750_000; // JDK 1.7에서부터는 숫자의 가독성을 향상시키기 위해서
        // 숫자에 _를 넣을 수 있는 기능을 지원
        int j = 900_000_000;
        System.out.println(i); // _는 출력되지 않는다
        System.out.println(j);

        System.out.println("--------------------------------");
        DecimalFormat sdf = new DecimalFormat("0,000,000");
        System.out.println(sdf.format(2024)); // 데이터가 없으면 0을 채워서 반환

        DecimalFormat sdf2 = new DecimalFormat("#,###,###");
        System.out.println(sdf2.format(2024)); // 데이터가 존재하는 것 까지만 반환

        DecimalFormat sdf3 = new DecimalFormat("#,###,###.00");
        System.out.println(sdf3.format(2024.0122)); // 데이터가 존재하는 것 까지만 반환

        DecimalFormat sdf4 = new DecimalFormat("#,###");
        System.out.println(sdf4.format(2147483647)); // 데이터가 존재하는 것 까지만 반환
    }

    public static void main(String[] args) {
        new UseDecimalFormat();
    }
}
