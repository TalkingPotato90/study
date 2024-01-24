package day0124;

import javax.swing.*;
import java.awt.*;

// 1. 윈도우 컴포넌트 상속
public class UseBorderLayout extends JFrame {
    public UseBorderLayout(){
        super("경계 레이아웃 연습");
        // 2. 컴포넌트 생성
        JButton jbtnNorth = new JButton("북쪽");
        JButton jbtnWest = new JButton("서쪽");
        JLabel jlblEast = new JLabel("동쪽");
        JLabel jlblSouth = new JLabel("남쪽");

        JTextArea jtaCenter = new JTextArea("가운데");

        // 3. 배치관리자 생성하고 적용
        // Window Component의 기본 배치관리자는 BorderLayout
//        setLayout(new BorderLayout());

        // 4. 생성된 컴포넌트를 배치관리자의 특성에 맞게 배치 수행
        add("North",jbtnNorth); // 문자열 상수 사용하여 배치
        add(BorderLayout.WEST, jbtnWest); // Constant 사용하여 배치
        add("Center", jtaCenter);
        add(jlblEast, "East");
        add(jlblSouth, BorderLayout.SOUTH);

        // 5. 윈도우 크기 설정
        setSize(500,500);

        // 6. 사용자에게 보여주기
        setVisible(true);

        // 7. 윈도우 종료 처리
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public static void main(String[] args) {
        new UseBorderLayout();
    }
}
