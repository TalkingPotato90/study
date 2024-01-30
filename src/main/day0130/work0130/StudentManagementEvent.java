package day0130.work0130;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class StudentManagementEvent extends WindowAdapter implements ActionListener {

    private StudentManagementDesign smd;

    public StudentManagementEvent(StudentManagementDesign smd) {
        this.smd = smd;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String cmd = ae.getActionCommand();
        if ("추가".equals(cmd)){
            addInfo();
        }
        if ("변경".equals(cmd)){
            editInfo();
        }
        if ("삭제".equals(cmd)){
            deleteInfo();
        }
        if ("종료".equals(cmd)){
            exit();
        }

    }

    @Override
    public void windowClosing(WindowEvent e) {
        smd.dispose();
    }

    private void addInfo() {

    }

    private void editInfo() {

    }

    private void deleteInfo() {

    }

    private void exit() {
        smd.dispose();
    }


}
