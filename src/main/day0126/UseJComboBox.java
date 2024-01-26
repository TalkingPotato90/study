package day0126;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class UseJComboBox extends JFrame {

    public UseJComboBox() {
        super("콤보 박스 연습");
        // 1. Model 생성
        DefaultComboBoxModel<String> dcbm = new DefaultComboBoxModel<String>();

        // 2. Model객체와 has a 관계로 View 생성
        JComboBox<String> jcb = new JComboBox<String>(dcbm);

        JPanel jp = new JPanel();
        jp.setBorder(new TitledBorder("MVC 패턴을 도입한 클래스들"));
        jp.add(jcb);

        add("North", jp);

        setSize(400,300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 3. 데이터 추가
        dcbm.addElement("고한별");
        dcbm.addElement("김도원");
        dcbm.addElement("김동섭");
        dcbm.addElement("김무영");
        dcbm.addElement("김병년");
        dcbm.addElement("김일신");
        dcbm.addElement("김현종");

    }

    public static void main(String[] args) {
        new UseJComboBox();
    }
}
