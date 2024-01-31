package day0131.work0131;

import javax.swing.*;

public class JavaMemoDesign extends JFrame {
    private JMenuItem jmiNew, jmiOpen, jmiSave, jmiClose, jmiFont, jmiHelp;
    private JTextArea jtaNote;
    private JScrollPane jspJtaNote;

    public JavaMemoDesign() {
        super("메모장");

        JMenuBar jmb = new JMenuBar();
        JMenu jmFile = new JMenu("파일");
        JMenu jmFont = new JMenu("서식");
        JMenu jmHelp = new JMenu("도움말");

        jmiNew = new JMenuItem("새글");
        jmiOpen = new JMenuItem("열기");
        jmiSave = new JMenuItem("저장");
        jmiClose = new JMenuItem("종료");
        jmiHelp = new JMenuItem("메모장 정보");
        jmiFont = new JMenuItem("글꼴");

        jtaNote = new JTextArea();
        jspJtaNote = new JScrollPane(jtaNote);


        jmHelp.add(jmiHelp);
        jmb.add(jmFile);
        jmFile.add(jmiNew);
        jmFile.addSeparator();
        jmFile.add(jmiOpen);
        jmFile.add(jmiSave);
        jmFile.addSeparator();
        jmFile.add(jmiClose);
        jmb.add(jmFont);
        jmFont.add(jmiFont);
        jmb.add(jmHelp);
        setJMenuBar(jmb);
        add(jspJtaNote);

        JavaMemoEvent jme = new JavaMemoEvent(this);
        jmiNew.addActionListener(jme);
        jmiOpen.addActionListener(jme);
        jmiSave.addActionListener(jme);
        jmiClose.addActionListener(jme);
        jmiFont.addActionListener(jme);
        jmiHelp.addActionListener(jme);


        setJFrame();
    }

    public void setJFrame() {
        setBounds(300, 100, 500, 500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public JMenuItem getJmiNew() {
        return jmiNew;
    }

    public JMenuItem getJmiOpen() {
        return jmiOpen;
    }

    public JMenuItem getJmiSave() {
        return jmiSave;
    }

    public JMenuItem getJmiClose() {
        return jmiClose;
    }

    public JTextArea getJtaNote() {
        return jtaNote;
    }

    public JScrollPane getJspJtaNote() {
        return jspJtaNote;
    }

    public JMenuItem getJmiFont() {
        return jmiFont;
    }

    public JMenuItem getJmiHelp() {
        return jmiHelp;
    }
}
