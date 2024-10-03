package day0124;

import javax.swing.*;
import java.awt.*;

// 1. 윈도우 컴포넌트 상속
public class UseFlowLayout extends JFrame {
    public UseFlowLayout(){
        super("FlowLayout 연습");
        // 2. 컴포넌트 생성
        JLabel jlblName = new JLabel("이름");
        JTextField jtfName = new JTextField(10);
        JCheckBox jcbSave = new JCheckBox("저장");
        JButton jbtnInput = new JButton("입력");



        // 3. 배치관리자 생성(Non - Visual Component)
        setLayout(new FlowLayout());

        // 4. 컴포넌트 배치
        add(jlblName);
        add(jtfName);
        add(jcbSave);
        add(jbtnInput);

        // 5. 윈도우 크기 설정
        setSize(500,400);

        // 6. 사용자에게 보여주기
        setVisible(true);

        // 7. 윈도우 종료 처리
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public static void main(String[] args) {
        new UseFlowLayout();

        JOptionPane.showInputDialog("메뉴\n1.입력 2.검색 3.종료");
        JOptionPane.showMessageDialog(null,"메시지 다이얼로그");
    }
}
