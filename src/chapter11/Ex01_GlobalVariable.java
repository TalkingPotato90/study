package chapter11;

class Cat{
    // static 변수
    // 프로그램이 시작하기도 전에 메서드 영역 내 스태틱 영역에 생성
    // 누구나 접근하여 사용 가능
    static int a = 5;
    int num = 3;

    void printValue(int num){
        this.num = num;
        System.out.println("num : " + this.num);
        System.out.println("a : " + a);
    }
}

public class Ex01_GlobalVariable {
    // 프로그램 시작 지점
    public static void main(String[] args) {
        // main의 지역변수 선언 및 값 대입
        int num1 = 5;
        int num2 = 2;
        System.out.println(num1 + ", " + num2);

        // cat1 변수를 스택 영역에 생성
        // Cat 객체를 힙 영역에 생성
        Cat cat1 = new Cat();
        // cat1의 인스턴스 변수 num에 값을 대입
        // num은 힙 영역에 생성된 객체 안에 있다
        cat1.num = 1;
        // static 변수에 직접 접근
        // a는 메서드 영역 내 static영역에 생성
        cat1.a =10;
        // 함수 호출
        cat1.printValue(20);
        System.out.println(cat1.num);
        System.out.println(cat1.a);

        // 스택 영역에 생성
        Cat cat2 = new Cat();
        cat2.num = 1;
        // static 변수에 직접 접근
        cat2.a =10;
        // 함수 호출
        cat2.printValue(10);
        System.out.println(cat2.num);
        System.out.println(cat2.a);
        System.out.println(cat1.a);
    }
}
