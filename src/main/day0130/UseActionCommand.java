package day0130;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UseActionCommand extends JFrame implements ActionListener {
    private JButton jbtn;
    private JButton jbtn2;
    private JTextField jtf;

    public UseActionCommand() {
        super("ActionCommand 사용");

        jbtn = new JButton("버튼");
        jbtn2 = new JButton("버튼2");
        jtf = new JTextField(10);

        // 컴포넌트를 이벤트에 등록
        jbtn.addActionListener(this);
        jbtn2.addActionListener(this);
        jtf.addActionListener(this);

        setLayout(new FlowLayout());

        add(jbtn);
        add(jbtn2);
        add(jtf);

        setBounds(100,100,400,300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
//        System.out.println("이벤트를 발생시킨 컴포넌트(객체)의 값 : " + ae.getActionCommand());
        String cmd = ae.getActionCommand();
        // command로 비교하여 이벤트 처리 가능 => 권장❌
        if ("버튼".equals(cmd)){
            System.out.println("버튼이 눌렸을 때 사용자에게 제공할 코드");
        }
        if ("버튼2".equals(cmd)){
            System.out.println("버튼2이 눌렸을 때 사용자에게 제공할 코드");
        }

        //JTextField에서 이벤트가 발생했을 때 비교할 수 없다
    }

    public static void main(String[] args) {
        new UseActionCommand();
    }
}
