package day0129;

import javax.swing.*;
import java.awt.*;

// 1. Window Component 상속
public class UseActionEvent extends JFrame {
    public UseActionEvent() {
        super("여러 레이아웃매니저 사용");
        // 2. 컴포넌트 생성
        JLabel jlblName = new JLabel("이름");
        JTextField jtfName = new JTextField(10);
        JComboBox<String> jcbGender = new JComboBox<String>();
        jcbGender.addItem("남자");
        jcbGender.addItem("여자");
        JButton jbtnInput = new JButton("입력");

        // 글꼴 적용
        // 1. Font 클래스 생성
        Font font = new Font("궁서체", Font.BOLD, 20);
        jlblName.setFont(font);
        jtfName.setFont(font);
        jcbGender.setFont(font);
        jbtnInput.setFont(font);

        // 글자색 => 상수
        jlblName.setForeground(Color.blue);
        // RGB
        Color color = new Color(0x03CD5C);
        jtfName.setForeground(color);
        jcbGender.setForeground(color);
        jbtnInput.setForeground(color);

        // 바닥이 투명한 컴포넌트는 투명도를 설정해야한다
        jlblName.setOpaque(true);
        jlblName.setBackground(new Color(0x3F7F5F));

        JTextArea jtaList = new JTextArea();
        jtaList.setFont(new Font("맑은 고딕", Font.BOLD | Font.ITALIC, 20));
        jtaList.setForeground(new Color(0x366C9A));
        jtaList.setBackground(Color.gray);

        // 3. 배치
        // BorderLayout은 하나의 영역에 하나의 컴포넌트만 배치된다
        // => Container Component 필요
//        add("North",jlblName);
//        add("North",jtfName);
//        add("North",jcbGender);
//        add("North",jbtnInput);

        // 여러개의 컴포넌트를 관리하기 위해서 Container Component를 사용
        JPanel jpNorth = new JPanel(); // FlowLayout
        jpNorth.add(jlblName); // JPanel에 컴포넌트를 배치
        jpNorth.add(jtfName);
        jpNorth.add(jcbGender);
        jpNorth.add(jbtnInput);

        // 윈도우 컴포넌트에 (사용자에게 보여주는 일) 배치
        add("North", jpNorth);
        add("Center", jtaList);

        // 4. 크기 설정
        setSize(450, 300);

        // 5. 가시화
        setVisible(true);

        // 6. 종료
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new UseActionEvent();
    }
}
