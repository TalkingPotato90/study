package day0206.work0206;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class JavaMemoDesign extends JFrame {
    private JMenuItem jmiNew, jmiOpen, jmiSave, jmiNewSave, jmiClose, jmiFont, jmiHelp;
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
        jmiNewSave = new JMenuItem("새이름으로 저장");
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
        jmFile.add(jmiNewSave);
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
        jmiNewSave.addActionListener(jme);
        jmiClose.addActionListener(jme);
        jmiFont.addActionListener(jme);
        jmiHelp.addActionListener(jme);


        setJFrame();
        applyFont();
    }

    private void applyFont() {
        File readFile = new File("d:/font.txt");
        try (BufferedReader reader = new BufferedReader(new FileReader(readFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    String key = parts[0].trim();
                    String value = parts[1].trim();

                    switch (key) {
                        case "fontName":
                            jtaNote.setFont(new Font(value, jtaNote.getFont().getStyle(), jtaNote.getFont().getSize()));
                            break;
                        case "fontStyle":
                            int fontStyle = Integer.parseInt(value);
                            jtaNote.setFont(new Font(jtaNote.getFont().getName(), fontStyle, jtaNote.getFont().getSize()));
                            break;
                        case "fontSize":
                            int fontSize = Integer.parseInt(value);
                            jtaNote.setFont(new Font(jtaNote.getFont().getName(), jtaNote.getFont().getStyle(), fontSize));
                            break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void setJFrame() {
        setBounds(300, 100, 800, 500);
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

    public JMenuItem getJmiNewSave() {
        return jmiNewSave;
    }
}
