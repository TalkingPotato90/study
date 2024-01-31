package day0131.work0131;


import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class MemoFontDesign extends JDialog {
    private JTextField jtfFont, jtfStyle, jtfSize;
    private JList jlFont, jlStyle, jlSize;
    private DefaultListModel<String> dlmFont, dlmStyle, dlmSize;
    private JLabel jlPreview;
    private JButton jbtnCheck, jbtnCancel;
    private JScrollPane jspFont, jspStyle, jspSize;
    private JavaMemoDesign jmd;
    private JTextArea superJtaNote;

    public MemoFontDesign(JavaMemoDesign jmd) {
        this.jmd = jmd;
        setTitle("글꼴");
        setLayout(null);

        jtfFont = new JTextField();
        jtfStyle = new JTextField();
        jtfSize = new JTextField();

        dlmFont = new DefaultListModel<>();
        dlmFont.addElement("고딕체");
        dlmFont.addElement("궁서체");
        dlmFont.addElement("Consolas");
        dlmFont.addElement("새굴림");
        dlmFont.addElement("맑은고딕");

        dlmStyle = new DefaultListModel<>();
        dlmStyle.addElement("일반");
        dlmStyle.addElement("굵게");
        dlmStyle.addElement("기울임꼴");
        dlmStyle.addElement("굵은 기울임꼴");

        dlmSize = new DefaultListModel<>();
        for (int i = 8; i < 81; ) {
            if (i < 10) {
                dlmSize.addElement(Integer.toString(i));
                i++;
            }
            if (i >= 10) {
                dlmSize.addElement(Integer.toString(i));
                i = i + 2;
            }
        }

        jlFont = new JList<>(dlmFont);
        jlStyle = new JList<>(dlmStyle);
        jlSize = new JList<>(dlmSize);

        jlPreview = new JLabel("AaBbYyZz가나다");
        jlPreview.setBorder(new TitledBorder("보기"));

        jbtnCheck = new JButton("확인");
        jbtnCancel = new JButton("취소");

        jspFont = new JScrollPane(jlFont);
        jspStyle = new JScrollPane(jlStyle);
        jspSize = new JScrollPane(jlSize);

        superJtaNote = jmd.getJtaNote();

        JLabel jlblFont, jlblStyle, jlblSize;
        jlblFont = new JLabel("글꼴(F):");
        jlblStyle = new JLabel("글꼴 스타일(Y):");
        jlblSize = new JLabel("크기(S):");

        jlblFont.setBounds(30, 10, 120, 30);
        jlblStyle.setBounds(220, 10, 100, 30);
        jlblSize.setBounds(350, 10, 50, 30);

        add(jlblFont);
        add(jlblStyle);
        add(jlblSize);

        jtfFont.setBounds(30, 40, 180, 20);
        jtfStyle.setBounds(220, 40, 120, 20);
        jtfSize.setBounds(350, 40, 80, 20);

        add(jtfFont);
        add(jtfStyle);
        add(jtfSize);

        jspFont.setBounds(30, 60, 180, 100);
        jspStyle.setBounds(220, 60, 120, 100);
        jspSize.setBounds(350, 60, 80, 100);

        add(jspFont);
        add(jspStyle);
        add(jspSize);

        jlPreview.setBounds(220, 180, 200, 80);
        jbtnCheck.setBounds(150, 280, 60, 30);
        jbtnCancel.setBounds(250, 280, 60, 30);

        add(jlPreview);
        add(jbtnCheck);
        add(jbtnCancel);

        MemoFontEvent mfe = new MemoFontEvent(this);
        addWindowListener(mfe);
        jlFont.addMouseListener(mfe);
        jlStyle.addMouseListener(mfe);
        jlSize.addMouseListener(mfe);
        jbtnCheck.addActionListener(mfe);
        jbtnCancel.addActionListener(mfe);

        setBounds(jmd.getX() + 50, jmd.getY() + 50, 490, 400);
        setVisible(true);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
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

    public JTextArea getSuperJtaNote() {
        return superJtaNote;
    }
}
