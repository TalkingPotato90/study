package day0131.work0131;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class JavaMemoEvent extends WindowAdapter implements ActionListener {
    private JavaMemoDesign jmd;

    public JavaMemoEvent(JavaMemoDesign jmd) {
        this.jmd = jmd;
    }

    @Override
    public void windowClosing(WindowEvent e) {
        jmd.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == jmd.getJmiNew()) {
            newMemo();
        }
        if (ae.getSource() == jmd.getJmiOpen()) {
            openMemo();
        }
        if (ae.getSource() == jmd.getJmiSave()) {
            saveMemo();
        }
        if (ae.getSource() == jmd.getJmiClose()) {
            closeMemo();
        }
        if (ae.getSource() == jmd.getJmiFont()) {
            fontDialog();
        }
        if (ae.getSource() == jmd.getJmiHelp()) {
            helpDialog();
        }
    }

    private void newMemo() {
        jmd.getJtaNote().setText("");
    }

    private void openMemo() {
        FileDialog fdOpen = new FileDialog(jmd, "열기모드", FileDialog.LOAD);
        fdOpen.setVisible(true);
        String path = fdOpen.getDirectory();
        String fName = fdOpen.getFile();
        if (path != null) {
            jmd.setTitle("열기 " + path + fName);
        }
    }

    private void saveMemo() {
        FileDialog fdOpen = new FileDialog(jmd, "저장모드", FileDialog.SAVE);
        fdOpen.setVisible(true);
        String path = fdOpen.getDirectory();
        String fName = fdOpen.getFile();
        if (path != null) {
            jmd.setTitle("저장 " + path + fName);
        }
    }

    private void closeMemo() {
        jmd.dispose();
    }

    private void fontDialog() {
        new MemoFontEvent(new MemoFontDesign(jmd));
    }

    private void helpDialog() {
        new MemoHelpEvent(new MemoHelpDesign(jmd));
    }
}
