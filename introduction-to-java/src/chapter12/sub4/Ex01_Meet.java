package chapter12.sub4;

// 인터페이스
interface Greet{
    void greet();
}

// 인터페이스
interface Talk{
    void talk();
}

// 인터페이스 구현
class Morning implements Greet, Talk{
    public void greet(){
        System.out.println("안녕하세요!");
    }

    public void talk(){
        System.out.println("날씨 좋네요.");
    }
}
public class Ex01_Meet {
    public static void main(String[] args) {
        Morning morning = new Morning();
        morning.greet();
        morning.talk();
    }
}
