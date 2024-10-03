package kr.co.memo;

import javax.swing.*;

public class JavaMemo extends JFrame {

    public JavaMemo() {
        super("메모장");

        JMenuBar jmb = new JMenuBar();
        JMenu jmFile = new JMenu("파일");
        JMenu jmHelp = new JMenu("도움말");
        JMenuItem jmiMemoInfo = new JMenuItem("메모장 정보");
        String[] menuItemArr = {"새글", "열기", "저장", "종료"};
        JMenuItem[] jmiArr = new JMenuItem[menuItemArr.length];
        JTextArea jta = new JTextArea();
        JScrollPane jsp = new JScrollPane(jta);

        for (int i = 0; i < menuItemArr.length; i++) {
            if (i == 1 || i == 3) {
                jmFile.addSeparator();
            }
            jmiArr[i] = jmFile.add(menuItemArr[i]);
        }

        jmHelp.add(jmiMemoInfo);
        jmb.add(jmFile);
        jmb.add(jmHelp);
        setJMenuBar(jmb);
        add(jsp);
        setJFrame();
    }

    public void setJFrame() {
        setBounds(300, 100, 300, 200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
