package day0131;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 부가적인 기능을 제공하기 위해 제작하는 창 : Dialog
 */
public class SubJDialog extends JDialog implements ActionListener {
    public SubJDialog(ParentFrame pf) { // Frame의 자식 창
//        super(pf,"부가적인 기능", true); // modal
        super(pf,"부가적인 기능", false); // non-modal

        ImageIcon ii = new ImageIcon("E:\\dev\\src\\sist-java-study\\src\\main\\day0125\\images\\img3.png");
        JLabel jlblBack = new JLabel("자식창에서 제공하는 이미지",ii,JLabel.CENTER);

        JButton jbtn = new JButton("닫기");
        JPanel jp = new JPanel();
        jp.add(jbtn);

        add("Center",jlblBack);
        add("South",jp);

        // JDialog는 이벤트 등록 코드를 setVisible 전에 정의해야 한다
        jbtn.addActionListener(this);
        // JDalog의 종료 : DISPOSE_ON_CLOSE 사용
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        setBounds(pf.getX() + 120,pf.getY() + 120,244,200);
        setVisible(true); // 사용자에게 보여지는 일

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        dispose();
    }
}
