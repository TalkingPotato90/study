package day0130;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class UseMouseListener2 extends JFrame implements MouseListener, ActionListener {

    // 이벤트와 관련 있는 컴포넌트를 인스턴스 변수에 선언
    private DefaultListModel<String> dlmFriend;
    private DefaultListModel<String> dlmBlockFriend;

    private JList<String> jlFriend;
    private JList<String> jlBlockFriend;

    private JButton jbtnBlockAll;
    private JButton jbtnRestoreAll;

    public UseMouseListener2() {
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
        jbtnRestoreAll = new JButton("<<");

        JScrollPane jspFriend = new JScrollPane(jlFriend);
        JScrollPane jspBlockFriend = new JScrollPane(jlBlockFriend);

        jspFriend.setBorder(new TitledBorder("친구"));
        jspBlockFriend.setBorder(new TitledBorder("차단된 친구"));

        // 이벤트에 컴포넌트를 등록
        jlFriend.addMouseListener(this);
        jbtnBlockAll.addActionListener(this);
        jbtnRestoreAll.addActionListener(this);
        jlBlockFriend.addMouseListener(this);

        setLayout(null);

        jspFriend.setBounds(20, 40, 150, 200);
        jbtnBlockAll.setBounds(190, 130, 50, 30);
        jspBlockFriend.setBounds(250, 40, 150, 200);
        jbtnRestoreAll.setBounds(190,180,50,30);

        add(jspFriend);
        add(jbtnBlockAll);
        add(jspBlockFriend);
        add(jbtnRestoreAll);

        setBounds(100, 100, 440, 300);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        // 친구 리스트에서 모든 값을 가져와서
        Object[] obj; // 배열 생성
        obj = dlmFriend.toArray(); // 친구 리스트의 모든 값을 배열로 복사
        // 차단된 친구 리스트에 넣고
        for (Object o : obj) {
            dlmBlockFriend.addElement(o.toString());
        }
        // 삭제한다
        dlmFriend.removeAllElements();

        if (ae.getSource() == jbtnRestoreAll){
            obj = dlmBlockFriend.toArray();
            for (Object o : obj) {
                dlmFriend.addElement(o.toString());
            }
            dlmBlockFriend.removeAllElements();
        }

    }

    @Override
    public void mouseClicked(MouseEvent me) {
//        System.out.println("mouseClicked"); // 키의 작업이 종료 된 후
        // 어떤 키가 눌리든 호출된다 : 키에 대한 비교
//        System.out.println(me.getButton()); // 눌려진 버튼의 값 얻기
        switch (me.getButton()) {
            case MouseEvent.BUTTON1:
                int ind = jlFriend.getSelectedIndex();
                if (ind != -1) {
                    // 선택된 인덱스에 해당하는 값을 Model에서 얻고
                    String name = dlmFriend.getElementAt(ind);

                    // 얻어낸 값을 차단된 친구로 등록 (dlmBlockFriend)
                    dlmBlockFriend.addElement(name);

                    // 선택된 인덱스에 해당하는 값을 Model에서 삭제
                    dlmFriend.remove(ind);
                }
        }
        if (me.getSource() == jlBlockFriend){
            int ind = jlBlockFriend.getSelectedIndex();
            if (ind != -1) {
                String name = dlmBlockFriend.getElementAt(ind);

                dlmFriend.addElement(name);

                dlmBlockFriend.remove(ind);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
//        System.out.println("mousePressed"); // 처음 클릭 되었을 때

    }

    @Override
    public void mouseReleased(MouseEvent e) {
//        System.out.println("mouseReleased"); // 클릭된 키가 올라왔을 때

    }

    @Override
    public void mouseEntered(MouseEvent e) {
//        System.out.println("mouseEntered");

    }

    @Override
    public void mouseExited(MouseEvent e) {
//        System.out.println("mouseExited");

    }

    public static void main(String[] args) {
        new UseMouseListener2();
    }

}
