package day0206.work0206;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MemoHelpEvent extends WindowAdapter implements ActionListener {
    private MemoHelpDesign mhd;

    public MemoHelpEvent(MemoHelpDesign mhd) {
        this.mhd = mhd;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == mhd.getJbtn()) {
            mhd.dispose();
        }
    }

    @Override
    public void windowClosing(WindowEvent e) {
        mhd.dispose();
    }
}
