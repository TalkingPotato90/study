package chapter09;

// Npc 클래스 정의
class Npc{
    // 필드 : 데이터
    // Npc 클래스에서 데이터로 사용할 것(필드) 정의
    String name;
    int hp;
    // 메서드 : 동작
    // Npc 클래스에서 기능으로 사용할 것(메서드) 정의
    void say()
    {
        System.out.println("안녕하세요");
    }
}

public class NpcUse {
    public static void main(String[] args) {
        // 클래스를 이용해 객체 생성
        // - 'Npc'라는 설계도(클래스)를 이용해 Npc 객체 만들기
        // 클래스 타입의 변수는 new를 통해 객체 생성
        // 클래스 타입의 참조 변수는 스택에, 생성된 객체는 힙에 적재됨

        // 자료형이 Npc 클래스형인 saram1 변수 생성
        Npc saram1 = new Npc();
        // 필드 접근
        // 객체의 필드는 .을 이용하여 접근
        // 객체의 멤버 변수 name에 값을 대입
        saram1.name="경비";
        // 객체의 멤버변수 hp에 값을 대입
        saram1.hp = 100;
        // 객체의 멤버 변수에 대입된 값을 출력
        System.out.println(saram1.name + ":"+saram1.hp);
        // 객체의 메서드를 호출해 기능을 동작
        saram1.say();
    }
}
