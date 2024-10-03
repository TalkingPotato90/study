package chapter11;
// 인스턴스 생성과 관계 없이 static 변수가 메모리
// 공간에 할당될 때 실행이 된다

// 임포트
// 랜덤 클래스를 임포트
import java.util.Random;
public class Ex02_Preload {
    // 스태틱 멤버 변수
    static int num;

    // static 초기화 블록
    static {
        // 임의의 숫자를 얻기 위해 Random 클래스를 이용하여 객체 생성
        Random rand = new Random();
        // main() 실행 전에 이미 난숫값이 대입된다
        // 만들어진 객체에서 nextInt()메서드 호출
        // 매개변수 100 이면 0에서 99 사이의 임의의 숫자 반환
        num = rand.nextInt(100);
    }

    public static void main(String[] args) {
        System.out.println(num);
    }
}
