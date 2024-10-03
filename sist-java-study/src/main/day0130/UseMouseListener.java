package day0130;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class UseMouseListener extends JFrame implements ListSelectionListener {

    // 이벤트와 관련 있는 컴포넌트를 인스턴스 변수에 선언
    private DefaultListModel<String> dlmFriend;
    private DefaultListModel<String> dlmBlockFriend;

    private JList<String> jlFriend;
    private JList<String> jlBlockFriend;

    private JButton jbtnBlockAll;
    public UseMouseListener(){
        super("친구 리스트");
        // MVC 패턴이 도입된 컴포넌트는 Model에 값을 설정한다
        dlmFriend = new DefaultListModel<>();
        dlmFriend.addElement("루피");
        dlmFriend.addElement("나루토");
        dlmFriend.addElement("이치고");
        dlmFriend.addElement("쵸파");
        dlmFriend.addElement("히루루크");

        dlmBlockFriend = new DefaultListModel<>();

        // 모델객체와 has a관계로 View객체를 생성
        jlFriend = new JList<>(dlmFriend);
        jlBlockFriend = new JList<>(dlmBlockFriend);

        jbtnBlockAll = new JButton(">>");

        JScrollPane jspFriend = new JScrollPane(jlFriend);
        JScrollPane jspBlockFriend = new JScrollPane(jlBlockFriend);

        jspFriend.setBorder(new TitledBorder("친구"));
        jspBlockFriend.setBorder(new TitledBorder("차단된 친구"));

        // 이벤트에 컴포넌트를 등록
        jlFriend.addListSelectionListener(this);
        setLayout(null);

        jspFriend.setBounds(20,40,150,200);
        jbtnBlockAll.setBounds(190,130,50,30);
        jspBlockFriend.setBounds(250,40,150,200);

        add(jspFriend);
        add(jbtnBlockAll);
        add(jspBlockFriend);

        setBounds(100,100,440,300);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new UseMouseListener();
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        System.out.println(dlmFriend.getElementAt(jlFriend.getSelectedIndex()));
    }
}
