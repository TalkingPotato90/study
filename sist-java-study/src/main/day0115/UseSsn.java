package day0115;

public class UseSsn {

    public static void main(String[] args) {
        String mySsn = "940728-2000000";
        SocialSecurityNumber num = new SocialSecurityNumber(mySsn);
        if (num.checkDigit()) {
            if (num.checkDash()) {
                System.out.println(num.birthDays());
                System.out.println(num.age() + "살");
                System.out.println(num.gender());
                System.out.println(num.zodiac());
            } else {
                System.out.println("- 의 위치가 올바르지 않음");
            }
        } else {
            System.out.println("주민번호의 자릿수가 잘못되엇음");
        }


    }//main

}//class
