package day0130.work0130;

import javax.swing.*;
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
        Object source = ae.getSource();

        for (JButton button : smd.getJbtnArrMenu()) {
            if (source == button) {
                buttonAction(button);
                break;
            }
        }
    }

    private void buttonAction(JButton button) {
        if (button == smd.getJbtnArrMenu()[0]) {
            addInfo();
        } else if (button == smd.getJbtnArrMenu()[1]) {
            editInfo();
        } else if (button == smd.getJbtnArrMenu()[2]) {
            deleteInfo();
        } else if (button == smd.getJbtnArrMenu()[3]) {
            exit();
        }
    }

    @Override
    public void windowClosing(WindowEvent e) {
        smd.dispose();
    }

    private void addInfo() {
        String name = smd.getJtfName().getText();
        String phone = smd.getJtfPhone().getText();
        String gender;

        if (smd.getJbMale().isSelected()) {
            gender = "남";
        } else {
            gender = "여";
        }

        int studentNumber = smd.getDlm().getSize() + 1;

        String studentInfo = studentNumber + ", " + name + ", " + gender + ", " + phone;
        smd.addInfoList(studentInfo);
    }

    private void editInfo() {

    }

    private void deleteInfo() {

    }

    private void exit() {
        smd.dispose();
    }


}
