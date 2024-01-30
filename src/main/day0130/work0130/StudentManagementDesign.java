package day0130.work0130;

import day0130.NameManagementEvent;

import javax.swing.*;

public class StudentManagementDesign extends JFrame {

    private JButton[] jbtnArrMenu;
    private JTextField jtfName;
    private JTextField jtfPhone;

    public StudentManagementDesign() {

        super("숙제");

        setLayout(null);

        addName();
        addAge();
        addGender();
        addPhone();

        DefaultListModel<String> dlm = new DefaultListModel<String>();

        JList<String> jlStudent = new JList<String>(dlm);

        dlm.addElement("1, 진수현, 남, 010-1234-5678");
        dlm.addElement("2, 김동섭, 남, 010-2345-6789");

        JScrollPane jsp = new JScrollPane(jlStudent);

        StudentManagementEvent sme = new StudentManagementEvent(this);
        addWindowListener(sme);
        for (JButton arrMenu : jbtnArrMenu) {
            arrMenu.addActionListener(sme);
        }
        jtfName.addActionListener(sme);
        jtfPhone.addActionListener(sme);

        jsp.setBounds(210, 15, 140, 180);

        add(jsp);

        setJFrame();
    }

    public void addName() {
        JLabel jlName = new JLabel("이름");
        jtfName = new JTextField();
        jlName.setBounds(30, 30, 30, 25);
        jtfName.setBounds(60, 30, 100, 25);
        add(jlName);
        add(jtfName);
    }

    public void addAge() {
        JLabel jlAge = new JLabel("나이");
        DefaultComboBoxModel<Integer> dcbm = new DefaultComboBoxModel<Integer>();
        JComboBox<Integer> jcbAge = new JComboBox<Integer>(dcbm);

        for (int i = 20; i < 41; i++) {
            dcbm.addElement(i);
        }

        JPanel jp = new JPanel();
        jp.setBounds(60, 65, 60, 30);

        jlAge.setBounds(30, 70, 30, 30);

        add(jlAge);
        jp.add(jcbAge);
        add(jp);
    }

    public void addGender(){
        JLabel jlGender = new JLabel("성별");

        JRadioButton jbMale = new JRadioButton("남");
        JRadioButton jbFemale = new JRadioButton("여", true);

        ButtonGroup genderGroup = new ButtonGroup();

        genderGroup.add(jbMale);
        genderGroup.add(jbFemale);

        jlGender.setBounds(30, 110, 30, 30);

        jbMale.setBounds(60, 110, 50, 30);
        jbFemale.setBounds(120, 110, 50, 30);

        addMenuButton();

        add(jlGender);
        add(jbMale);
        add(jbFemale);
    }

    public void addPhone() {
        JLabel jlPhone = new JLabel("전화번호");
        jtfPhone = new JTextField();
        jlPhone.setBounds(30, 150, 50, 30);
        jtfPhone.setBounds(90, 155, 100, 25);
        add(jlPhone);
        add(jtfPhone);
    }

    public void addMenuButton() {
        String[] strArrMenuName = {"추가", "변경", "삭제", "종료"};
        jbtnArrMenu = new JButton[strArrMenuName.length];

        for (int i = 0; i < strArrMenuName.length; i++) {
            jbtnArrMenu[i] = new JButton(strArrMenuName[i]);
            jbtnArrMenu[i].setBounds((i + 1) * 60 + i * 10, 230, 60, 25);
            add(jbtnArrMenu[i]);
        }
    }

    public void setJFrame() {
        setBounds(500, 100, 400, 320);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public JButton[] getJbtnArrMenu() {
        return jbtnArrMenu;
    }

    public JTextField getJtfName() {
        return jtfName;
    }

    public JTextField getJtfPhone() {
        return jtfPhone;
    }
}
