package day0125;

import javax.swing.*;

public class UseImageIcon extends JFrame {
    public UseImageIcon() {
        super("이미지 연습");

        ImageIcon ii = new ImageIcon("E:\\dev\\src\\sist-java-study\\src\\main\\day0125\\images\\img1.png");
        ImageIcon ii2 = new ImageIcon("E:\\dev\\src\\sist-java-study\\src\\main\\day0125\\images\\img4.png");

        JLabel jl = new JLabel(ii);
        JButton jbtn = new JButton(ii2);
        JButton jbtn2 = new JButton("버튼");

        setLayout(null); // 수동배치

        jl.setBounds(100,100,300,200);
        jbtn.setBounds(420,100,300,200);
        jbtn2.setBounds(215,195,60,30);
        // Frame에 컴포넌트 배치
        add(jl);
        add(jbtn);
        add(jbtn2);

        setBounds(100,100,800,400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new UseImageIcon();
    }
}
