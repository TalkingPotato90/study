package chapter12.sub5;

abstract class Human {
    abstract void print();
}

class Man extends Human {
    void print() {
        System.out.println("남자 생성");
    }
}

class Woman extends Human {
    void print() {
        System.out.println("여자 생성");
    }
}

public class Ex02_Polymorphism2 {
    // 입력되는 매개변수에 따라 두 가지 타입의 객체 생성
    // 그러나 메서드 반환값은 하나
    public static Human humanCreate(int kind) {
        if (kind == 1) {
            // 객체를 만들고 상위 클래스형의 변수에 넣어서 반환
            //Human m = new Man();
            //return m;
            // return 값에 직접 입력하면 자동 형변환
            return new Man();
        } else {
            //Human w = new Woman();
            //return w;
            return new Woman();
        }
    }

    public static void main(String[] args) {
        // 생성된 객체가 남자인지 여자인지 중요하지 않고
        // 난 생성된 객체의 프린트 기능만 쓸 것이다.
        // 남자이면 남자애가 가진 기능을 할 것이고,
        // 여자이면 여자애가 가진 기능을 할 것이다.

        Human h1 = humanCreate(1);
        h1.print();

        Human h2 = humanCreate(2);
        h2.print();
    }
}
