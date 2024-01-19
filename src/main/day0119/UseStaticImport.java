package day0119;

import static java.lang.Integer.MAX_VALUE;
// import static java.lang.Long.MAX_VALUE;
// 같은 이름의 constant는 여러개 static import 할 수 있으나 아래의 코드에서 에러 발생

import static java.lang.Integer.parseInt;
import static java.lang.Math.random;

public class UseStaticImport {
    public static void main(String[] args) {
        System.out.println(MAX_VALUE);
        System.out.println(MAX_VALUE);
        System.out.println(MAX_VALUE);
        System.out.println(MAX_VALUE);

        String str = "2024";
        System.out.println(parseInt(str));
        System.out.println(parseInt(str));
        System.out.println(parseInt(str));
        System.out.println(parseInt(str));

        System.out.println(random());

    }
}
