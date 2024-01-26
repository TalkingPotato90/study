package kr.co.sist.memo;

import javax.swing.*;

public class JavaMemo extends JFrame {

    public JavaMemo() {
        super("메모장");
        JMenuBar jmb = new JMenuBar();

        JMenu jmFile = new JMenu("파일");
        JMenu jmHelp = new JMenu("도움말");

        JMenuItem jmiNewText = new JMenuItem("새글");
        JMenuItem jmiOpenText = new JMenuItem("열기");
        JMenuItem jmiSaveText = new JMenuItem("저장");
        JMenuItem jmiExitText = new JMenuItem("종료");

        JMenuItem jmiMemoInfo = new JMenuItem("메모장 정보");


        jmFile.add(jmiNewText);
        jmFile.addSeparator();
        jmFile.add(jmiOpenText);
        jmFile.add(jmiSaveText);
        jmFile.addSeparator();
        jmFile.add(jmiExitText);

        jmHelp.add(jmiMemoInfo);

        jmb.add(jmFile);
        jmb.add(jmHelp);

        setJMenuBar(jmb);

        JTextArea jta = new JTextArea();

        JScrollPane jsp = new JScrollPane(jta);

        add(jsp);

        setBounds(300, 100, 300, 200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
