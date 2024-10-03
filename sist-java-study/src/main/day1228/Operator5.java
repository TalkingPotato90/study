package day1228;

/*
논리연산자
 일반논리 : 여러개의 관계연산자를 붙여서 연산할 때 사용
 && (AND) - 전항과 후항이 모두 true 일 때만 true 반환
 || (OR) - 전항과 후항이 모두 false 일 때만 false 반환
*/
class Operator5 {
    public static void main(String[] args) {
        boolean flag = true, flag2 = false, flag3 = true, flag4 = false;

        System.out.println("---------- AND ----------");
        System.out.println(flag + " && " + flag3 + " = " + (flag && flag3)); // true
        System.out.println(flag + " && " + flag2 + " = " + (flag && flag2)); // false
        System.out.println(flag2 + " && " + flag + " = " + (flag2 && flag)); // false
        System.out.println(flag2 + " && " + flag4 + " = " + (flag2 && flag4)); // false

        System.out.println("---------- OR ----------");
        System.out.println(flag + " || " + flag3 + " = " + (flag || flag3)); // true
        System.out.println(flag + " || " + flag2 + " = " + (flag || flag2)); // true
        System.out.println(flag2 + " || " + flag + " = " + (flag2 || flag)); // true
        System.out.println(flag2 + " || " + flag4 + " = " + (flag2 || flag4)); // false

        System.out.println("=========================");
        // && : 전항이 false라면 후항을 연산하지 않는다.
        // || : 전항이 true라면 후항을 연산하지 않는다.

        flag = false;
        flag2 = false;
        flag3 = false;

        flag3 = (flag = 3 < 2) && (flag2 = 5 < 6);

        System.out.println(flag + " && " + flag2 + " = " + flag3);

        System.out.println("=========================");

        int octalNum = 8; // 임의의 한자리의 양의수; // 0 ~ 9
        // octalNum이 8진수의 범위(0 ~ 7)라면 true를 그렇지 않다면 false를 출력해보세요
        System.out.print(octalNum + "은(는) ");
        System.out.println(0 <= octalNum && octalNum <= 7);

    } // main
} // class
