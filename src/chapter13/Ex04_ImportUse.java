package chapter13;

// 사용하고자 하는 클래스를 패키지명하고 같이 써서 임포트
import chapter13.com.study.Banana;

public class Ex04_ImportUse {
    public static void main(String[] args) {
        // 임포트한 클래스는 패키지명 없이 사용 가능
        Banana banana = new Banana();
        banana.showName();
    }
}
