package chapter12.sub5;

abstract class Animal {
    abstract void doMove();
}

class Tiger extends Animal {
    void doMove() {
        System.out.println("호랑이는 산을 달립니다.");
    }
}

class Lion extends Animal {
    void doMove() {
        System.out.println("사자는 평원을 달립니다.");
    }
}

public class Ex04_Polymorphism3 {
    // 매개변수로 어떤 형태의 객체를 참조하는 변수가 들어올지 알 수 없기 때문에 상위 클래스로 지정
    // 하위 클래스 매개변수를 넘겨도 자동 형변환
    public static void animalChoose(Animal obj) {
        if (obj instanceof Tiger) {
            Tiger tiger = (Tiger) obj;
            tiger.doMove();
        } else {
            Lion lion = (Lion) obj;
            lion.doMove();
        }
    }

    public static void main(String[] args) {
        Tiger tiger = new Tiger();
        animalChoose(tiger);

        Lion lion = new Lion();
        animalChoose(lion);
    }
}
