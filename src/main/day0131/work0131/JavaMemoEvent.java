package day0131.work0131;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class JavaMemoEvent extends WindowAdapter implements ActionListener {
    private JavaMemoDesign jmd;

    public JavaMemoEvent(JavaMemoDesign jmd){
        this.jmd = jmd;
    }

    @Override
    public void windowClosing(WindowEvent e) {
        super.windowClosing(e);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

    }

    private void newMemo(){}
    private void openMemo(){}
    private void saveMemo(){}
    private void closeMemo(){}
    private void fontDialog(){}
    private void helpDialog(){}
}
