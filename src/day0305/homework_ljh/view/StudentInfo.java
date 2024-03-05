package day0305.homework_ljh.view;

import day0305.homework_ljh.event.StudentInfoEvent;

import javax.swing.*;

@SuppressWarnings("serial")
public class StudentInfo extends JFrame {

    private JLabel jlbNum, jlbName, jlbImg, jlbAge, jlbInputDate, jlbImg2;
    private JTextField jtfNum, jtfName, jtfAge, JtfInputDate;
    private JComboBox<String> jcbImg;
    private JList<String> jlSVO;
    private DefaultListModel<String> dlmSVO;
    private JButton jbtnAdd, jbtnEdit, jbtnDelete, jbtnExit;
    private String imgName;

    public StudentInfo() {
        super("만들기 싫어요");
        setLayout(null);

        setLb();
        setJtf();
        setCbb();
        setJlist();
        setLbImg();
        setBtn();
        setAction();

        setBounds(100, 100, 800, 450);
        setVisible(true);
    }    // StudentInfo

    private void setAction() {
        StudentInfoEvent sie = new StudentInfoEvent(this);

        addWindowListener(sie);
        jlSVO.addListSelectionListener(sie);
        jcbImg.addActionListener(sie);
        jbtnAdd.addActionListener(sie);
        jbtnEdit.addActionListener(sie);
        jbtnDelete.addActionListener(sie);
        jbtnExit.addActionListener(sie);
    }    // setAction

    private void setLb() {
        jlbNum = new JLabel("번호");
        jlbName = new JLabel("이름");
        jlbImg = new JLabel("이미지");
        jlbAge = new JLabel("나이");
        jlbInputDate = new JLabel("입력일");

        jlbNum.setBounds(30, 50, 70, 30);
        jlbName.setBounds(30, 100, 70, 30);
        jlbImg.setBounds(30, 150, 70, 30);
        jlbAge.setBounds(30, 200, 70, 30);
        jlbInputDate.setBounds(30, 250, 70, 30);

        add(jlbNum);
        add(jlbName);
        add(jlbImg);
        add(jlbAge);
        add(jlbInputDate);
    }    // setLb

    private void setJtf() {
        jtfNum = new JTextField();
        jtfName = new JTextField();
        jtfAge = new JTextField();
        JtfInputDate = new JTextField();

        jtfNum.setEditable(false);
        JtfInputDate.setEditable(false);

        jtfNum.setBounds(100, 50, 120, 30);
        jtfName.setBounds(100, 100, 120, 30);
        jtfAge.setBounds(100, 200, 120, 30);

        JtfInputDate.setBounds(100, 250, 120, 30);

        add(jtfNum);
        add(jtfName);
        add(jtfAge);
        add(JtfInputDate);
    }    // setJtf

    private void setCbb() {
        String[] imgNameArr = {"img1.png", "img2.png", "img3.png", "img4.png"};
        jcbImg = new JComboBox<>(imgNameArr);

        jcbImg.setSelectedItem("img4.png");
        jcbImg.setBounds(100, 150, 120, 30);

        add(jcbImg);
    }    // setCbb

    private void setJlist() {
        dlmSVO = new DefaultListModel<>();
        jlSVO = new JList<>(dlmSVO);
        JScrollPane jsp = new JScrollPane(jlSVO);

        jsp.setBounds(250, 50, 220, 250);

        add(jsp);
    }    // setJlist

    public void setLbImg() {
        if (jlbImg2 != null) {
            remove(jlbImg2);
        }

        this.imgName = StudentInfoEvent.selectImgName;
        System.out.println(imgName);
        ImageIcon img = new ImageIcon("D:/dev/src/sist-jdbc-prj/src/day0305/homework/img/" + imgName);

        jlbImg2 = new JLabel(img);

        jlbImg2.setBounds(500, 50, 244, 172);
        add(jlbImg2);

        repaint();
    }    // setLbImg

    private void setBtn() {
        jbtnAdd = new JButton("추가");
        jbtnEdit = new JButton("변경");
        jbtnDelete = new JButton("삭제");
        jbtnExit = new JButton("종료");

        jbtnAdd.setBounds(200, 350, 80, 30);
        jbtnEdit.setBounds(300, 350, 80, 30);
        jbtnDelete.setBounds(400, 350, 80, 30);
        jbtnExit.setBounds(500, 350, 80, 30);

        add(jbtnAdd);
        add(jbtnEdit);
        add(jbtnDelete);
        add(jbtnExit);
    }    // setBtn

    public JTextField getJtfNum() {
        return jtfNum;
    }

    public JTextField getJtfName() {
        return jtfName;
    }

    public JTextField getJtfAge() {
        return jtfAge;
    }

    public JTextField getJtfInputDate() {
        return JtfInputDate;
    }

    public JComboBox<String> getJcbImg() {
        return jcbImg;
    }

    public JList<String> getJlSVO() {
        return jlSVO;
    }

    public DefaultListModel<String> getDlmSVO() {
        return dlmSVO;
    }


    public JButton getJbtnAdd() {
        return jbtnAdd;
    }

    public JButton getJbtnEdit() {
        return jbtnEdit;
    }

    public JButton getJbtnDelete() {
        return jbtnDelete;
    }

    public JButton getJbtnExit() {
        return jbtnExit;
    }
}    // class