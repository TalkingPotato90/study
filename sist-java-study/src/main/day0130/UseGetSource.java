package day0130;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UseGetSource extends JFrame implements ActionListener {
    private JButton jbtn;
    private JButton jbtn2;
    private JTextField jtf;

    public UseGetSource() {
        super("주소를 사용한 이벤트 발생객체 비교");

        jbtn = new JButton("버튼");
        jbtn2 = new JButton("버튼2");
        jtf = new JTextField(10);

        System.out.println(jbtn);
        System.out.println(jbtn2);
        System.out.println(jtf);

        // 컴포넌트를 이벤트에 등록
        jbtn.addActionListener(this);
        jbtn2.addActionListener(this);
        jtf.addActionListener(this);

        setLayout(new FlowLayout());

        add(jbtn);
        add(jbtn2);
        add(jtf);

        setBounds(100, 100, 400, 300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
//        System.out.println(ae.getSource());
        // getSource() 이벤트를 발생시킨 객체의 주소가 반환
        if (ae.getSource() == jbtn) {
            System.out.println("버튼이 눌렸을 때 제공할 코드");
        }
        if (ae.getSource() == jbtn2) {
            System.out.println("버튼2가 눌렸을 때 제공할 코드");
        }
        // J.T.F도 주소를 사용하면 입력값이 무엇이든 비교가 가능하다
        if (ae.getSource() == jtf) {
            System.out.println("텍스트필드에서 엔터가 눌렸을 때 제공할 코드");
        }

    }

    public static void main(String[] args) {
        new UseGetSource();
    }
}
