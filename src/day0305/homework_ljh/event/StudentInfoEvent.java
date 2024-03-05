package day0305.homework_ljh.event;

import day0305.homework_ljh.dao.StudentInfoDAO;
import day0305.homework_ljh.view.StudentInfo;
import day0305.homework_ljh.vo.StudentVO;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.List;

import static java.lang.Integer.parseInt;

public class StudentInfoEvent extends WindowAdapter implements ActionListener, ListSelectionListener {

    private StudentInfo si;
    private StudentInfoDAO siDAO;
    private StudentVO sVO;
    private int age, studentNum;
    private String name, imgName;
    public static String selectImgName = "img4.png";

    public StudentInfoEvent(StudentInfo si) {
        this.si = si;
        siDAO = StudentInfoDAO.getInstance();
        viewList();
    }    // StudentInfoEvent

    public void viewList() {
        try {
            List<StudentVO> listSVO = siDAO.selectAll();
            DefaultListModel<String> dlmSVO = si.getDlmSVO();

            StringBuilder output = new StringBuilder();

            for (StudentVO sVO : listSVO) {
                output.append(sVO.getNum()).append(",")
                        .append(sVO.getName()).append(",")
                        .append(sVO.getImg_name()).append(",")
                        .append(sVO.getAge()).append(",")
                        .append(sVO.getInput_date()).append(",")
                        .append(sVO.getStudentNum());

                dlmSVO.addElement(output.toString());
                output.delete(0, output.length());
            }    // end for
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }    // viewList

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == si.getJcbImg()) {
            selectImgName = si.getJcbImg().getSelectedItem().toString();
            si.setLbImg();
        }    // end if

        if (e.getSource() == si.getJbtnAdd()) {
            age = parseInt(si.getJtfAge().getText());
            name = si.getJtfName().getText();
            imgName = si.getJcbImg().getSelectedItem().toString();

            sVO = new StudentVO(age, name, imgName, null);
            try {
                siDAO.insert(sVO);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }    // end catch
            si.getDlmSVO().removeAllElements();
            viewList();
            resetJtf();
            JOptionPane.showMessageDialog(si, "정보가 추가되었습니다.");
        }    // end if

        if (e.getSource() == si.getJbtnEdit()) {
            age = parseInt(si.getJtfAge().getText());
            name = si.getJtfName().getText();
            imgName = si.getJcbImg().getSelectedItem().toString();

            sVO = new StudentVO(age, name, imgName, null, studentNum);

            try {
                siDAO.update(sVO);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }    // end catch

            si.getDlmSVO().removeAllElements();
            viewList();
            resetJtf();
            JOptionPane.showMessageDialog(si, "정보가 변경되었습니다.");
        }    // end if

        if (e.getSource() == si.getJbtnDelete()) {
            try {
                siDAO.delete(studentNum);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }    // end catch

            si.getDlmSVO().removeAllElements();
            viewList();
            resetJtf();
            JOptionPane.showMessageDialog(si, "정보가 삭제되었습니다.");

        }    // end if

        if (e.getSource() == si.getJbtnExit()) {
            si.dispose();
        }    // end if
    }    // actionPerformed

    public void resetJtf() {
        si.getJtfNum().setText("");
        si.getJtfName().setText("");
        si.getJtfAge().setText("");
        si.getJtfInputDate().setText("");
    }    // resetJtf

    @Override
    public void windowClosing(WindowEvent e) {
        si.dispose();
    }    // windowClosing

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (si.getDlmSVO().isEmpty()) {
            return;
        }    // end if

        String[] tempArr = null;
        if (!si.getJlSVO().getValueIsAdjusting()) {
            tempArr = si.getJlSVO().getSelectedValue().split(",");

            si.getJtfNum().setText(tempArr[0]);
            si.getJtfName().setText(tempArr[1]);
            si.getJcbImg().setSelectedItem(tempArr[2]);
            si.getJtfAge().setText(tempArr[3]);
            si.getJtfInputDate().setText(tempArr[4]);
            studentNum = parseInt(tempArr[5]);
        }    // end if
    }    // valueChanged

}    // class