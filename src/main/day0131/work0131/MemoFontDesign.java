package day0131.work0131;

import javax.swing.*;

public class MemoFontDesign extends JDialog {
    private JTextField jtfFont,jtfStyle,jtfSize;
    private JList jlFont,jlStyle,jlSize;
    private DefaultListModel<String> dlmFont,dlmStyle,dlmSize;
    private JLabel jlPreview;
    private JButton jbtnCheck,jbtnCancel;
    private JavaMemoDesign jmd;

    public MemoFontDesign(JavaMemoDesign jmd){
        this.jmd = jmd;
    }

    public JTextField getJtfFont() {
        return jtfFont;
    }

    public JTextField getJtfStyle() {
        return jtfStyle;
    }

    public JTextField getJtfSize() {
        return jtfSize;
    }

    public JList getJlFont() {
        return jlFont;
    }

    public JList getJlStyle() {
        return jlStyle;
    }

    public JList getJlSize() {
        return jlSize;
    }

    public DefaultListModel<String> getDlmFont() {
        return dlmFont;
    }

    public DefaultListModel<String> getDlmStyle() {
        return dlmStyle;
    }

    public DefaultListModel<String> getDlmSize() {
        return dlmSize;
    }

    public JLabel getJlPreview() {
        return jlPreview;
    }

    public JButton getJbtnCheck() {
        return jbtnCheck;
    }

    public JButton getJbtnCancel() {
        return jbtnCancel;
    }
}
