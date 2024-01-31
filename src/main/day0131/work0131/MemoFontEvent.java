package day0131.work0131;

import day0131.SubJDialog;

import java.awt.event.*;

public class MemoFontEvent extends WindowAdapter implements ActionListener, MouseListener {

    private MemoFontDesign mfd;

    public MemoFontEvent(MemoFontDesign mfd) {
        this.mfd = mfd;
    }

    @Override
    public void windowClosing(WindowEvent e) {
        super.windowClosing(e);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    private void setPreview() {
    }

    private void applyFont() {
    }

    private void closeFontDialog() {
    }
}
