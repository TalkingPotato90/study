package chapter12.sub5;

interface Cry {
    void cry();
}

class Cat implements Cry {
    public void cry() {
        System.out.println("야옹~");
    }
}

class Dog implements Cry {
    public void cry() {
        System.out.println("멍멍!");
    }
}

public class Ex03_instanceof {
    public static void main(String[] args) {
        Cry test1 = new Cat();
        // Dog 클래스도 다형성 적용 가능
//        Cry test1 = new Dog();

        // test1에 있는 참조 값이 Cat의 객체인지 Dog의 객체인지에 따라 코드 진행
        if (test1 instanceof Cat){
            test1.cry();
        } else if(test1 instanceof Dog){
            System.out.println("고양이가 아닙니다.");
        }
    }
}
