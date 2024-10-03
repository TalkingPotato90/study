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
        File fontFile = new File("C:/dev/font.txt");
        if (!fontFile.exists()) {
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(fontFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                initialFont(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initialFont(String line) {
        String[] parts = line.split(":");
        if (parts.length == 2) {
            String key = parts[0].trim();
            String value = parts[1].trim();

            switch (key) {
                case "fontName":
                    setFontName(value);
                    break;
                case "fontStyle":
                    setFontStyle(value);
                    break;
                case "fontSize":
                    setFontSize(value);
                    break;
            }
        }
    }

    private void setFontName(String fontName) {
        Font currentFont = jtaNote.getFont();
        jtaNote.setFont(new Font(fontName, currentFont.getStyle(), currentFont.getSize()));
    }

    private void setFontStyle(String fontStyle) {
        int style = Integer.parseInt(fontStyle);
        Font currentFont = jtaNote.getFont();
        jtaNote.setFont(new Font(currentFont.getName(), style, currentFont.getSize()));
    }

    private void setFontSize(String fontSize) {
        int size = Integer.parseInt(fontSize);
        Font currentFont = jtaNote.getFont();
        jtaNote.setFont(new Font(currentFont.getName(), currentFont.getStyle(), size));
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
