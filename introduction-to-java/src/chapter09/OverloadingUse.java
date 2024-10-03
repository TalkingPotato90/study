package chapter09;

class Calc {
    int add(int a, int b) {
        return a + b;
    }

    int add(int a) {
        return a + 1;
    }

    double add(double a, double b) {
        return a + b;
    }
}

public class OverloadingUse {
    public static void main(String[] args) {
        // 자료형이 Calc 클래스형인 calc 변수를 생성
        Calc calc = new Calc();
        // 객체의 add() 메서드 호출, 매개변수 : int 두 개
        int nRtn1 = calc.add(3,9);
        // 객체의 add() 메서드 호출, 매개변수 : int 한 개
        int nRtn2 = calc.add(3);
        // 객체의 add() 메서드 호출, 매개변수 : double 두 개
        double nRtn3 = calc.add(3.0, 9.0);

        System.out.println("Rtn1 = " + nRtn1);
        System.out.println("Rtn2 = " + nRtn2);
        System.out.println("Rtn3 = " + nRtn3);
    }
}
