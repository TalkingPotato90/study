package chap01;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AwtHelloWorld {
    public static void main(String[] args) {
        // 프레임 객체 생성
        Frame f = new Frame("Hello World 윈도우즈");
        // 레이블 객체 생성 후 정 중앙에 배치
        Label label1 = new Label("Hello World", Label.CENTER);
        // 프레임에 레이블 추가
        f.add(label1);
        // 크기 지정
        f.setSize(400,100);
        // 화면 출력
        f.setVisible(true);
        // 종료 버튼 누르면 프로그램 종료
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent event){
                System.exit(0);
            }
        });
    }
}
