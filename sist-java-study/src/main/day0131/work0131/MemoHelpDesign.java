package day0131.work0131;

import javax.swing.*;

public class MemoHelpDesign extends JDialog {
    private JTextArea jtaMemoInfo;
    private JButton jbtn;
    private JavaMemoDesign jmd;
    private MemoHelpEvent mhe;

    public MemoHelpDesign(JavaMemoDesign jmd){
        super(jmd,"메모장 정보", true);

        this.jmd = jmd;

        jtaMemoInfo = new JTextArea("Java 메모장 Version1.0\n이 메모장은 SHPL(SuHyun Public License)로서 아무나 가져다 변환 및 배포 가능합니다.\n편하게 가져다 사용해주세요");
        jtaMemoInfo.setLineWrap(true);
        jbtn = new JButton("닫기");
        JPanel jp = new JPanel();
        jp.add(jbtn);

        add("Center",jtaMemoInfo);
        add("South",jp);

        mhe = new MemoHelpEvent(this);

        jbtn.addActionListener(mhe);
        setDefaultCloseOperation(MemoHelpDesign.DISPOSE_ON_CLOSE);

        setBounds(jmd.getX() + 100,jmd.getY() + 100,244,200);
        setVisible(true);
    }

    public JButton getJbtn() {
        return jbtn;
    }
}
