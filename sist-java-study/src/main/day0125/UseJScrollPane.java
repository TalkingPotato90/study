package day0125;

import javax.swing.*;
import java.awt.*;

public class UseJScrollPane extends JFrame {

    public UseJScrollPane() {
        super("스크롤 바 연습");

        JTextArea jta = new JTextArea("as;oeh;rnqWJKE'DGVD");
        String[] dataArr = "자바,오라클,JDBC,HTML,CSS,JavaScript,JavaScript Library,Servlet/JSP,JSON,XML,AJAX".split(",");
        JList<String> jl = new JList<>(dataArr);

        // BorderLayout -> GridLayout으로 배치관리자 변경
        setLayout(new GridLayout(1, 2));

        // 스크롤 바가 필요한 컴포넌트를 위해 JScrollPane을 생성
        JScrollPane jsp = new JScrollPane(jta);
        JScrollPane jsp2 = new JScrollPane(jl);

//        add(jta);
//        add(jl);
        add(jsp);
        add(jsp2);

        setBounds(100, 100, 300, 100);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new UseJScrollPane();


    }
}
