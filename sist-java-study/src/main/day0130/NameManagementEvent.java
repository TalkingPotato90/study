package day0130;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * 이벤트를 모아서 처리하기 위해 작성
 */
public class NameManagementEvent extends WindowAdapter implements ActionListener {

    private NameManagementDesign nmd;

    public NameManagementEvent(NameManagementDesign nmd) {
        this.nmd = nmd;

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        // 이벤트비교
        if (ae.getSource() == nmd.getJbtnAdd()) {
            addName();
        }
        if (ae.getSource() == nmd.getJbtnRemove()) {
            removeName();
        }
    }

    @Override
    public void windowClosing(WindowEvent we) {
        nmd.dispose();
    }

    private void addName() {
        JTextField jtfName = nmd.getJtfName();
        // 이름을 가져와서
        String name = jtfName.getText().trim();

        if(!name.isEmpty()){
            // Model객체에 값을 설정한다
            nmd.getDlmName().addElement(name);
            jtfName.setText(""); // 값이 입력된 후 텍스트필드를 초기화한다
            jtfName.requestFocus(); // 다음 입력이 편하도록 커서를 위치한다
        }
    }

    private void removeName() {
        JTextField jtfName = nmd.getJtfName();
        // 하나만 삭제
//        nmd.getDlmName().removeElement(jtfName.getText().trim());
        DefaultListModel<String > dlmName = nmd.getDlmName();
        List<String > list = new ArrayList<String >();
        String tempName ="";
        for (int i = 0; i < dlmName.size(); i++) {
            tempName = dlmName.getElementAt(i);
            if (!jtfName.getText().equals(tempName)){ // J.T.F의 이름과 같지 않은 이름만 리스트에 추가
                list.add(null);
            }
        }

        dlmName.removeAllElements(); // Model의 모든 아이템을 삭제하고

        for (String name : list) { // 리스트에 저장된 값으로 Model에 추가
            dlmName.addElement(name);
        }
    }
}
